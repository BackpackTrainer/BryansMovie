package com.barclays.movies.service;

import com.barclays.movies.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    Logger logger = LoggerFactory.getLogger((MovieServiceImpl.class));

    @Override
    public Movie save(Movie movie) {
        logger.info("Entering the save function");

        if(movie.getId() !=0) {
           logger.debug("id!=)");
        }
        else {
            logger.debug("id == 0");

            }
        return movie;
    }

    @Override
    public List<Movie> findAll()  {
        logger.info("Entering findAll function");

        List<Movie> movies = new ArrayList<>();
           Movie movie = new Movie();
           movie.setId(2L);
           movie.setTitle("Knives Out");
           movie.setIsbn("2346-02");
           movies.add(movie);

            movie = new Movie();
            movie.setId(1L);
            movie.setTitle("Glass Onion");
            movie.setIsbn("2346-01");
            movies.add(movie);

        return movies;
    }

    @Override
    public Movie findById(Long id)  {
        logger.info("Entering the findById function");

        Movie movie = new Movie();

        if(id == 0) {
            movie.setId(1234L);
            movie.setTitle("Random");
            movie.setIsbn("2456-99");
        }
        else {
            movie.setId(id);
            movie.setIsbn("123-567");
            movie.setTitle("A Fake Movie");
        }
        return movie;
    }
}


