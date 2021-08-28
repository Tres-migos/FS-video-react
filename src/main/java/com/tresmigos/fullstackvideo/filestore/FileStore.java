package com.tresmigos.fullstackvideo.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.Tag;
import com.tresmigos.fullstackvideo.bucket.BucketName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class FileStore {

    private final AmazonS3 s3Client;

    @Autowired
    public FileStore(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public void save(String filePath, String fileName, Optional<Map<String, String>> optionalTags){
        PutObjectRequest putRequest = new PutObjectRequest(
                BucketName.PROFILE_VIDEO.getBucketName(),
                fileName,
                new File(filePath));

        List<Tag> tags = new ArrayList<>();
        
        optionalTags.ifPresent(map -> {
            if(!map.isEmpty()){
                map.forEach((key,value) -> tags.add(new Tag(key,value)));
            }
        });
        putRequest.setTagging(new ObjectTagging(tags));

        try{
            s3Client.putObject(putRequest);
        } catch(AmazonServiceException e){
            throw new IllegalStateException("Failed to store file to S3", e);
        }



    }


}
