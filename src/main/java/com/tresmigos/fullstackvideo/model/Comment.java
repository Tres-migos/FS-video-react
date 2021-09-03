package com.tresmigos.fullstackvideo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    private String text;
    private Date datePosted;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Video video;

    private Long videoId;

}
