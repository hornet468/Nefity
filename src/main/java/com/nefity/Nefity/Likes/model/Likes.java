package com.nefity.Nefity.Likes.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nefity.Nefity.Posts.model.Posts;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Likes {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private LocalDateTime timestamp;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnore
    private Posts post;
}
