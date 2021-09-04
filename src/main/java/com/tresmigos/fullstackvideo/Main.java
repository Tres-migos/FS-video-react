package com.tresmigos.fullstackvideo;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Tag;
import com.tresmigos.fullstackvideo.filestore.FileStore;
import com.tresmigos.fullstackvideo.model.Account;
import com.tresmigos.fullstackvideo.service.AwsServiceClient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        AwsServiceClient awsServiceClient = new AwsServiceClient();
//        //awsServiceClient.addTag("Thresh Unbound", "type", "trailer");
//        awsServiceClient.deleteTag("Thresh Unbound", "type","trailer");
//
//        List<Tag> tags =  awsServiceClient.getVideoTags("Thresh Unbound");
//        for(Tag tag: tags){
//            System.out.println(tag.getValue());
//        }

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//        EntityManager em = emf.createEntityManager();
//
//        Account account = em.find(Account.class, 1);

    }

}
