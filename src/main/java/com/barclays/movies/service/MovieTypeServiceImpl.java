package com.barclays.movies.service;

import com.barclays.movies.model.Movie;
import com.barclays.movies.model.MovieType;
import com.barclays.movies.repository.MovieTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieTypeServiceImpl implements MovieTypeService {

    private final MovieTypeRepository movieTypeRepository;

    public MovieTypeServiceImpl(MovieTypeRepository movieTypeRepository) {
        this.movieTypeRepository = movieTypeRepository;
    }

    @Override
    public MovieType getMovieType(String type) {

        return movieTypeRepository.findByType(type);
    }

    public MovieType save(MovieType movieType) {

        Optional<MovieType> optMovieType = Optional.ofNullable(movieTypeRepository.findByType(movieType.getType()));

        if(optMovieType.isPresent()) {
            movieType = optMovieType.get();
        }else {
            movieType = movieTypeRepository.save(movieType);
        }
        return movieType;
    }
}

