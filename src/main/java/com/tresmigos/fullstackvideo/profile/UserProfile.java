package com.tresmigos.fullstackvideo.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {
    private UUID UserProfileID;
    private String username;
    private String userProfileImageLink;  //s3 key

    public UserProfile(UUID UserProfileID, String username, String userProfileImageLink) {
        this.UserProfileID = UserProfileID;
        this.username = username;
        this.userProfileImageLink = userProfileImageLink;
    }

    public UUID getUserProfileID() {
        return UserProfileID;
    }

    public void setUserProfileID(UUID userProfileID) {
        this.UserProfileID = userProfileID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Optional<String> getUserProfileImageLink() {
        return Optional.ofNullable(userProfileImageLink);
    }

    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile userProfile = (UserProfile) o;
        return Objects.equals(UserProfileID, userProfile.UserProfileID) &&
                Objects.equals(username, userProfile.username) &&
                Objects.equals(userProfileImageLink, userProfile.userProfileImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserProfileID, username, userProfileImageLink);
    }
}
