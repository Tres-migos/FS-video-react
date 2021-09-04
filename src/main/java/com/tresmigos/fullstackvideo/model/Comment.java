package com.tresmigos.fullstackvideo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    private String text;
    private Date datePosted;

    @ManyToOne
    @JsonBackReference
    private Video video;

}
