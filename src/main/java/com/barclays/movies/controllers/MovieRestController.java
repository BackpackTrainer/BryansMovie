package com.barclays.movies.controllers;

import com.barclays.movies.model.Movie;
import com.barclays.movies.model.MovieType;
import com.barclays.movies.service.MovieService;
import com.barclays.movies.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MovieRestController {

    private MovieService movieService;
    private MovieTypeService movieTypeService;

    public MovieRestController()  {}

    @Autowired
    public MovieRestController(MovieService movieService, MovieTypeService movieTypeService) {
        this.movieService = movieService;
        this.movieTypeService = movieTypeService;
    }

    @GetMapping("/movies")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody List<Movie> getAllMovies()  {
        return movieService.findAll();
    }


    @PostMapping(path = "/addMovie")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie newMovie) {
        System.out.println("addMovie() successfully called.  The movie type is " + newMovie.getMovieType().getType());

        MovieType newMovieType = movieTypeService.save(newMovie.getMovieType());
        newMovie.setMovieType(newMovieType);
        Movie movie = movieService.save(newMovie);

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
}
