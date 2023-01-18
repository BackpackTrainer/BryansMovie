package com.barclays.movies.service;

import com.barclays.movies.model.Movie;
import com.barclays.movies.repository.MovieRepository;
import com.barclays.movies.repository.MovieTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    Logger logger = LoggerFactory.getLogger((MovieServiceImpl.class));

    private final MovieRepository movieRepository;

    private final MovieTypeRepository movieTypeRepository;

    public MovieServiceImpl(MovieRepository movieRepository, MovieTypeRepository movieTypeRepository) {
        this.movieRepository = movieRepository;
        this.movieTypeRepository = movieTypeRepository;
    }

    @Override
    public Movie save(Movie movie) {
        logger.info("Entering the save function");

    movie = movieRepository.saveAndFlush(movie);
        return movie;
    }

    @Override
    public List<Movie> findAll()  {
        logger.info("Entering findAll function");

        List<Movie> movies = movieRepository.findAll();

        return movies;
    }

    @Override
    public Movie findById(Long id)  {
        logger.info("Entering the findById function");

        Movie movie = null;
        Optional<Movie> optMovie = movieRepository.findById(id);

        if(optMovie.isPresent()) {
            movie = optMovie.get();
        }else {
            movie = movieRepository.getReferenceById(1L);
        }
        return movie;
    }
}


