package com.tresmigos.fullstackvideo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import com.tresmigos.fullstackvideo.model.Account;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "VIDEO_ID")
    private Long id;

    private String name;
    private String genre;
    private String description;


    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

//    public Video() { }
//
//    public Video(Long id, String name, String genre, String description, Account account) {
//        this.id = id;
//        this.name = name;
//        this.genre = genre;
//        this.description = description;
////        this.account = account;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String title) {
//        this.name = name;
//    }
//
//    public String getGenre() {
//        return this.genre;
//    }

}
