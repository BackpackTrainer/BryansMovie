package com.barclays.movies.controllers;

import com.barclays.movies.model.Movie;
import com.barclays.movies.model.MovieType;
import com.barclays.movies.repository.MovieTypeRepository;
import com.barclays.movies.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;
    private MovieTypeRepository movieTypeRepository;

    public MovieController(MovieService movieService, MovieTypeRepository movieTypeRepository) {
        this.movieService = movieService;
        this.movieTypeRepository = movieTypeRepository;
    }

    @ModelAttribute("movieTypeList")
    public List<MovieType> getMovieTypeList()  {
        return movieTypeRepository.findAll();
    }

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
                movieService.save(movie);
            }
            return modelAndView;
        }
        @GetMapping("/edit")
        public ModelAndView edit(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("addMovie");

        Movie movie = movieService.findById(id);

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
