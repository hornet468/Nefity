package com.nefity.Nefity.Posts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class Posts {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String text;
    private String author;
    private LocalDateTime timestamp;
    private String comments;
}
