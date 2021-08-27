package com.tresmigos.fullstackvideo;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Tag;
import com.tresmigos.fullstackvideo.service.AwsServiceClient;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AwsServiceClient awsServiceClient = new AwsServiceClient();
        //awsServiceClient.addTag("Thresh Unbound", "type", "trailer");
        awsServiceClient.deleteTag("Thresh Unbound", "type","trailer");
        List<Tag> tags =  awsServiceClient.getVideoTags("Thresh Unbound");
        for(Tag tag: tags){
            System.out.println(tag.getValue());
        }
    }

}
