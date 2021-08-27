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
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.Tag;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AwsServiceClient {

    private AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();

    private BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAYTOCM7274OJNTG5T", "wCFpa6VjWovm0tvPAfeLK3Pu9TaA3VtMj1IPqWnV");
    private AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .build();

    public AwsServiceClient() {
    }

    public void putInBucket(String filePath, String key_name, String genre, String actua) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setUserMetadata("genre",genre);


        try {
            File fileToUpload = new File(filePath);
            InputStream inStream = new FileInputStream(fileToUpload);
            s3Client.putObject("tres-migos-videos", key_name, inStream, metadata);
        } catch (AmazonServiceException | FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage() );
            System.exit(1);
        }
    }

    public void putInBucketWithTag(String videoName, String filePath, String genre){
        PutObjectRequest putRequest = new PutObjectRequest("tres-migos-videos", videoName, new File(filePath));
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(new Tag("genre", genre));
        //tags.add(new Tag("Tag 2", "This is tag 2"));
        putRequest.setTagging(new ObjectTagging(tags));
        s3Client.putObject(putRequest);
        s3Client.setObjectTagging()
    }

    public void deleteFromBucket(String object_key){
        try {
            s3Client.deleteObject("tres-migos-videos", object_key);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    public String getObjUrl(String objectKey){
        return s3Client.getUrl("tres-migos-videos", objectKey).toString();
    }


}
