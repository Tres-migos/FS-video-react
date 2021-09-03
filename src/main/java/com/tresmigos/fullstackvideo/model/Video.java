package com.tresmigos.fullstackvideo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VIDEO_ID")
    private Long videoId;

    @Column(name = "ACCOUNT_ID")
    private Integer accountId;

    private String title;
    private String category;
    private String description;
    private String videoURL;
    private String datePosted;

    @OneToMany(mappedBy = "video")
    @JsonIgnore
    List<Comment> comments;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "accountId")
    private Account account;

    public Video() { }

}
