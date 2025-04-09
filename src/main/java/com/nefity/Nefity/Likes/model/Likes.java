package com.nefity.Nefity.Likes.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Likes {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("likes")
    private UserInfo user;
    private LocalDateTime timestamp;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", nullable = false)
    //@JsonIgnoreProperties("likes")
    @JsonIgnore
    private Posts post;
}
