package com.tresmigos.fullstackvideo.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ErrorManager;

import java.lang.*;

@Service
public class AwsServiceClient {

    private AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();

    private BasicAWSCredentials awsCreds = new BasicAWSCredentials
            (System.getenv("S3_KEY"), System.getenv("S3_SECRET"));
    private AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .build();

    public AwsServiceClient() {
    }

    @Autowired
    private VideoService videoService;

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

    public void uploadFile(MultipartFile file) {
//        Video video = new Video();
//        video.setName(name);
//        video.setGenre(genre);
//        video.setDescription(description);
//        Long videoId = videoService.create(video).getId();

        File fileObj = convertMultiPartFileToFile(file);
        String name = fileObj.getName();
        s3Client.putObject(
                new PutObjectRequest("tres-migos-videos", name, fileObj)
        );
        fileObj.delete(); // delete so it doesn't keep adding it
    }

    public File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            ErrorManager log = new ErrorManager();
            log.error("Error converting multipartFile to file", e,5);
        }

        return convertedFile;
    }



}
