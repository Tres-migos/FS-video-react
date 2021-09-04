package com.tresmigos.fullstackvideo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "ACCOUNT_ID")
    private Long id;
    private String username;
    private String password;

    @OneToMany(targetEntity = Video.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "acc_key",
            referencedColumnName = "id")
    @JsonManagedReference
    private List<Video> videos;

}
