package com.tresmigos.fullstackvideo.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
        this.userProfileDataAccessService = userProfileDataAccessService;
    }

    List<UserProfile> getUserProfiles(){
        return userProfileDataAccessService.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userprofileId, MultipartFile file) {
        //1. Check if image is not empty
        //2. Check if file is an image
        //3. Check if user exist in db
        //4. If yes, grab some metadata from file if any
        //5. Store the image in s3 and update db (userProfileImageLink) with s3 image link
    }
}
