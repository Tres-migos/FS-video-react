package com.tresmigos.fullstackvideo;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.tresmigos.fullstackvideo.service.AwsServiceClient;

public class Main {
    public static void main(String[] args) {
        AwsServiceClient awsServiceClient = new AwsServiceClient();
        //awsServiceClient.putInBucketWithTag("/Users/nathan/Downloads/ThreshUnbound.mp4","Thresh Unbound", "Game");

        awsServiceClient.deleteFromBucket("More - KDA");

    }

}
