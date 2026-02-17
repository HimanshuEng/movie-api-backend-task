<<<<<<< HEAD
package com.freelance.movie_api.service;

import com.freelance.movie_api.dto.MovieRequestDto;
import com.freelance.movie_api.dto.MovieResponseDto;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    // Add a new movie (RequestDto -> Entity -> ResponseDto)
    MovieResponseDto addMovie(MovieRequestDto movieRequestDto) ;

    // Fetch movie by id
    MovieResponseDto getMovieById(int id);

    // Fetch all movies
    List<MovieResponseDto> getAllMovie();

    // Delete movie by id (returns true if deleted)
    boolean deleteById(int id);

    // Update movie by id and return updated movie
    MovieResponseDto updateMovie(int id, MovieRequestDto movieRequestDto);
}
=======
package com.freelance.movie_api.service;

import com.freelance.movie_api.dto.MovieRequestDto;
import com.freelance.movie_api.dto.MovieResponseDto;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    // Add a new movie (RequestDto -> Entity -> ResponseDto)
    MovieResponseDto addMovie(MovieRequestDto movieRequestDto) ;

    // Fetch movie by id
    MovieResponseDto getMovieById(int id);

    // Fetch all movies
    List<MovieResponseDto> getAllMovie();

    // Delete movie by id (returns true if deleted)
    boolean deleteById(int id);

    // Update movie by id and return updated movie
    MovieResponseDto updateMovie(int id, MovieRequestDto movieRequestDto);
}
>>>>>>> 86fa909a0d62f6b9ca5feb7c6be4b8fa0ca916c8
