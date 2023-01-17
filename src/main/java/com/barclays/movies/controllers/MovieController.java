package com.barclays.movies.controllers;

import com.barclays.movies.model.Movie;
import com.barclays.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("movies");

        List<Movie> movies = movieService.findAll();

        modelAndView.addObject("movies", movies);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add()  {
        ModelAndView modelAndView = new ModelAndView("addMovie");

        Movie movie = movieService.findById(0L);

        modelAndView.addObject("movie", movie);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {

        Movie movie = movieService.findById(id);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        ModelAndView modelAndView = new ModelAndView("movies");
        modelAndView.addObject("movies", movies);

        return modelAndView;
    }

        @PostMapping
        public ModelAndView post(@Valid @ModelAttribute Movie movie, BindingResult result) {
            ModelAndView modelAndView = new ModelAndView();

            if(result.hasErrors()) {
                modelAndView.setViewName("addMovie");
            }
            else {
                modelAndView.setViewName("addMovie");

                modelAndView.addObject("addMovieSuccess", true);
                modelAndView.addObject("addMovieTitle", movie.getTitle());

                modelAndView.addObject("movie", movie);
            }
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
