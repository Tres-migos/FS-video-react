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

import java.io.File;

public class AwsServiceClient {

    private AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();

    private BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAYTOCM7274OJNTG5T", "wCFpa6VjWovm0tvPAfeLK3Pu9TaA3VtMj1IPqWnV");
    private AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .build();

    public AwsServiceClient() {
    }

    public void putInBucket(String file_path, String key_name) {
        try {
            s3Client.putObject("tres-migos-videos", key_name, new File(file_path));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
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
