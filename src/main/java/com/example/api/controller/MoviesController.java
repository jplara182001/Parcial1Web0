package com.example.api.controller;

import com.example.api.entities.MoviesEntity;
import com.example.api.services.MoviesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/parcial/eu/jplr/v0/movies")
public class MoviesController {

    @Autowired
    private MoviesServices moviesServices;

    @PostMapping
    public String createData(@RequestBody MoviesEntity movie) {
        return moviesServices.createMovie(movie);
    }

    @GetMapping
    public List<MoviesEntity> readData() {
        return moviesServices.getAllMovies();
    }

    @PutMapping("/{id}")
    public String updateData(@PathVariable UUID id, @RequestBody MoviesEntity updatedMovie) {
        return moviesServices.updateMovie(id, updatedMovie);
    }

    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable UUID id) {
        return moviesServices.deleteMovie(id);

    }
}
