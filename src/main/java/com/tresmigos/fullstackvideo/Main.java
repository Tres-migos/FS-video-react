package com.tresmigos.fullstackvideo;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.tresmigos.fullstackvideo.service.AwsServiceClient;

public class Main {
    public static void main(String[] args) {
        AwsServiceClient awsServiceClient = new AwsServiceClient();
        //awsServiceClient.putInBucket("KDA-more.mp4","More - KDA","music");

        //awsServiceClient.putInBucketWithTag("More - KDA", "KDA-more.mp4","music");
        System.out.println(awsServiceClient.getObjUrl("Porter Robinson - Shelter"));


    }

}
