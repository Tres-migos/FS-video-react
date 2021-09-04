package com.tresmigos.fullstackvideo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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
    @JsonBackReference
    private Account account;


    @OneToMany(targetEntity = Comment.class,
    cascade = CascadeType.ALL)
    @JoinColumn(name = "video_key",
    referencedColumnName = "id")
    @JsonManagedReference
    private List<Comment> comments;

}
