package com.barclays.movies.model;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE_TYPE")
public class MovieType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "TYPE")
    private String type;

    public MovieType(String type)  {
        this.type = type;
    }

    public MovieType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setMovieType(String type) {
        this.type = type;
    }

}
