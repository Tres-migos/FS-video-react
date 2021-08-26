package com.tresmigos.fullstackvideo;

import com.tresmigos.fullstackvideo.service.AwsServiceClient;

public class Main {
    public static void main(String[] args) {
        AwsServiceClient awsServiceClient = new AwsServiceClient();
        //awsServiceClient.putInBucket("FirstAidFail.mp4","First Aid Fail - The Office");
        System.out.println(awsServiceClient.getObjUrl("NewRules-DuaLipa"));
    }

}
