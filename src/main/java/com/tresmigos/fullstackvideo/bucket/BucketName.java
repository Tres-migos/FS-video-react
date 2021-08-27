package com.tresmigos.fullstackvideo.bucket;

public enum BucketName {
    PROFILE_VIDEO("tres-migos-videos");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
