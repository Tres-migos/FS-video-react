package com.tresmigos.fullstackvideo.model;

import javax.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VIDEO_ID")
    private Long id;

    @Column(name = "ACCOUNT_ID")
    private Integer accountId;
    private String name;
    private String genre;
    private String description;

    public Video() { }

    public Video(Long id, String name, Integer accountId, String genre, String description) {
        this.id = id;
        this.name = name;
        this.accountId = accountId;
        this.genre = genre;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = name;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //tried this at 944
}
