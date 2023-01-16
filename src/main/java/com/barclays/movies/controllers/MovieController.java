package com.barclays.movies.controllers;

import com.barclays.movies.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("movies");

        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Glass Onion");
        movie.setIsbn("2345-02");

        movies.add(movie);

        movie = new Movie();
        movie.setId(2L);
        movie.setTitle("Knives Out");
        movie.setIsbn("2346-02");

        movies.add(movie);

        modelAndView.addObject("movies", movies);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add()  {
        ModelAndView modelAndView = new ModelAndView("addMovie");

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Random The Sequel");
        movie.setIsbn("2457-99");

        modelAndView.addObject("movie", movie);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle("Random");
        movie.setIsbn("2456-99");

        List<Movie> movies = new ArrayList<>();

        ModelAndView modelAndView = new ModelAndView("movies");

        movies.add(movie);

        modelAndView.addObject("movies", movies);
        return modelAndView;
        }

        @PostMapping
        public ModelAndView post(Movie movie) {
            ModelAndView modelAndView = new ModelAndView("addMovie");

            System.out.println("Title: " + movie.getTitle());
            modelAndView.addObject("addMovieSuccess", true);
            modelAndView.addObject("addMovieTitle", movie.getTitle());

            modelAndView.addObject("movie", movie);

            return modelAndView;
        }

        @PutMapping
        public @ResponseBody String put () {
            return "put";
        }

        @DeleteMapping
        public @ResponseBody String delete () {
            return "delete";
        }
}
