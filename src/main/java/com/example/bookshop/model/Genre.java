package com.example.bookshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "genre_name")
    private String genreName;
}
