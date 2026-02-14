package com.freelance.movie_api.repository;

import com.freelance.movie_api.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository // Marks this class as Repository layer (Data Access Layer)
public class MovieRepository {

    private final List<Movie> movieList = new ArrayList<>();
    private int counter = 1;

    /* Save movie into list.
     * Assign auto-generated id and store movie object.*/
    public Movie save(Movie movie){
        movie.setId(counter++);
        movieList.add(movie);
        return movie;
    }

    /* Find movie by id.
     * If movie exists, return Movie object.
     * If not found, return null.*/
    public Movie findById(int id){
        for(Movie movie : movieList){
            if (movie.getId()==id){
                return movie;
            }
        }
        return null;
    }

    /* Fetch all movies from list.
     * Returns complete list of movies.*/
    public List<Movie> findAll(){
        return movieList;
    }

    /* Delete movie by id.
     * removeIf() removes matching movie from list.
     * Returns:
     * true  -> if movie deleted successfully
     * false -> if movie not found*/
    public boolean deleteById(int id){
    return movieList.removeIf(movie -> movie.getId()== id);
    }

    /* Update movie by id.
     * First find the existing movie.
     * If found, update fields and return updated movie.
     * If not found, return null.*/
    public Movie updateById(int id,Movie updateMovie){
        Movie existingMovie = findById(id);
        if(existingMovie!=null){
         existingMovie.setTitle(updateMovie.getTitle());
         existingMovie.setDescription(updateMovie.getDescription());
         existingMovie.setGenre(updateMovie.getGenre());
         existingMovie.setRating(updateMovie.getRating());
            return existingMovie;
        }
        return  null;
    }
}
