package com.example.api.services;

import com.example.api.entities.MoviesEntity;
import com.example.api.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MoviesServices {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<MoviesEntity> getAllMovies(){
        return moviesRepository.findAll();
    }

    public String createMovie(MoviesEntity movie){
        moviesRepository.save(movie);
        return "Movie created";
    }

    public String updateMovie(UUID id, MoviesEntity updatedMovie) {
        if (moviesRepository.existsById(id)) {
            updatedMovie.setId(id);
            updatedMovie.setTitle(updatedMovie.getTitle());
            updatedMovie.setDirector(updatedMovie.getDirector());
            updatedMovie.setGenre(updatedMovie.getGenre());
            updatedMovie.setRelease_year(updatedMovie.getRelease_year());
            moviesRepository.save(updatedMovie);
            return "Movie updated";
        }
        return "Movie not found";
    }

    public String deleteMovie(UUID id) {
        if (moviesRepository.existsById(id)) {
            moviesRepository.deleteById(id);
            return "Movie deleted";
        }
        return "Movie not found";
    }


}
