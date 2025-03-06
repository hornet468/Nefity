package com.nefity.Nefity.Posts.model;

import lombok.Data;


@Data
public class Posts {
    private String title;
    private String text;
    private String author;
    private String  timestamp;
    private String comments;
}
