package com.tresmigos.fullstackvideo;

import com.tresmigos.fullstackvideo.service.AwsServiceClient;

public class Main {
    public static void main(String[] args) {
        AwsServiceClient awsServiceClient = new AwsServiceClient();
        awsServiceClient.putInBucket("FirstAidFail.mp4","First Aid Fail - The Office");
        AwsServiceClient awsServiceClient1 = new AwsServiceClient();
        awsServiceClient.putInBucket("valorantRetake.mp4", "Valorant - Retake");
        AwsServiceClient awsServiceClient2 = new AwsServiceClient();
        awsServiceClient.putInBucket("Shelter.mp4", "Porter Robinson - Shelter");
        System.out.println(awsServiceClient2.getObjUrl("Porter Robinson - Shelter"));
        System.out.println(awsServiceClient1.getObjUrl("Valorant - Retake"));
        System.out.println(awsServiceClient.getObjUrl("NewRules-DuaLipa"));

    }

}
