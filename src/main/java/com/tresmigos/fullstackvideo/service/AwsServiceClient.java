package com.tresmigos.fullstackvideo.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AwsServiceClient {

    private AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();

    private BasicAWSCredentials awsCreds = new BasicAWSCredentials("", "");
    private AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .build();

    public AwsServiceClient() {
    }

    public void putInBucket(String filePath, String fileName) {
        try {
            s3Client.putObject("tres-migos-videos", fileName, new File(filePath));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    public void putInBucketWithTag( String filePath, String videoName, String genre){
        PutObjectRequest putRequest = new PutObjectRequest("tres-migos-videos", videoName, new File(filePath));
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(new Tag("genre", genre));
        //tags.add(new Tag("Tag 2", "This is tag 2"));
        putRequest.setTagging(new ObjectTagging(tags));
        s3Client.putObject(putRequest);
    }

    public void deleteFromBucket(String object_key){
        try {
            s3Client.deleteObject("tres-migos-videos", object_key);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    public String getObjUrl(String bucket, String objectKey){
        return s3Client.getUrl(bucket, objectKey).toString();
    }

    public ObjectListing getListOfObjects(String bucketname) {
        return s3Client.listObjects(bucketname);
    }

    public void setTags(String fileName, List<Tag> tagList){
        ObjectTagging objectTags = new ObjectTagging(tagList);
        SetObjectTaggingRequest setTagRequest = new SetObjectTaggingRequest("tres-migos-videos",fileName, objectTags );
        s3Client.setObjectTagging(setTagRequest);
    }

    public void addTag(String fileName, String tagKey, String tagValue){
        Tag tag = new Tag(tagKey,tagValue);
        List<Tag> tagList = getVideoTags(fileName);
        tagList.add(tag);
        setTags(fileName,tagList);
    }

    public List<Tag> getVideoTags(String fileName){
        GetObjectTaggingRequest fileTagRequest = new GetObjectTaggingRequest("tres-migos-videos",fileName);
        GetObjectTaggingResult taggingResult = s3Client.getObjectTagging(fileTagRequest);
        List<Tag> tagList = new ArrayList<>();
        taggingResult.getTagSet().forEach(tagList::add);
        return tagList;
    }

    public void deleteAllTags(String fileName){
        DeleteObjectTaggingRequest deleteTags = new DeleteObjectTaggingRequest("tres-miogs-videos", fileName);
        s3Client.deleteObjectTagging(deleteTags);
    }

    public void deleteTag(String fileName, String tagKey, String tagValue) {
        Tag tag = new Tag(tagKey,tagValue);
        List<Tag> tagList = getVideoTags(fileName);
        if(!tagList.contains(tag)){
            System.out.println(fileName+" does not have tag: "+tagKey+": "+tagValue);
        } else {
            tagList.remove(tag);
            setTags(fileName,tagList);
            System.out.println("Tag: "+tagKey+": "+tagValue+" was deleted from: "+fileName);
        }
    }


}
