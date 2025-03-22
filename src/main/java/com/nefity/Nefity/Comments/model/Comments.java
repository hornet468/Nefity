package com.nefity.Nefity.Comments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comments {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"posts", "comments", "likes"})
    private UserInfo user;
    private String commentsText;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnore
    private Posts post;
}
