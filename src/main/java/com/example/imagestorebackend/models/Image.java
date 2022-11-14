package com.example.imagestorebackend.models;

import lombok.Data;

import java.util.Date;

@Data
public class Image {
    Integer id;
    Long size;
    String user;
    String name;
    String title;
    String description;
    String image;
    Date created;
}

