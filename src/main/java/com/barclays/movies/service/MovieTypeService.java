package com.barclays.movies.service;

import com.barclays.movies.model.MovieType;
import org.springframework.stereotype.Service;


public interface MovieTypeService {
    public MovieType getMovieType(String type);

    MovieType save(MovieType movieType);
}
