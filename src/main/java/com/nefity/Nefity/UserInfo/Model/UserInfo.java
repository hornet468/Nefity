package com.nefity.Nefity.UserInfo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nefity.Nefity.Comments.model.Comments;
import com.nefity.Nefity.Likes.model.Likes;
import com.nefity.Nefity.Posts.model.Posts;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserInfo {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String nickName; //getName
    private String email;
    private String password;
    private String country;
    private String profilePhoto;
    private LocalDate dateOfBirth;
    private String categoryProfile;
    private int age;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<Posts> posts = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<Comments> comments = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<Likes> likes = new ArrayList<>();
}

