package com.example.bookshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorId;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genreId;

}
