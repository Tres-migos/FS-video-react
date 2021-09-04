package com.tresmigos.fullstackvideo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "ACCOUNT_ID")
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private List<Video> videos;


    public Account() {
    }


    public Account(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        //this.videos = videos;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Video> getVideos() {
//        return videos;
//    }
//
//    public void setVideos(List<Video> videos) {
//        this.videos = videos;
//    }
}
