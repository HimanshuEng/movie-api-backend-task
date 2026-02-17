package com.freelance.movie_api.controller;

import com.freelance.movie_api.dto.MovieRequestDto;
import com.freelance.movie_api.dto.MovieResponseDto;
import com.freelance.movie_api.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as REST Controller (returns JSON/String response)
@RequestMapping("/movie") // Base URL for all movie APIs
public class MovieController {

    private final MovieService movieService;

    // Constructor Injection
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // POST API -> Add new movie
    // URL: POST /movie
    @PostMapping
        public ResponseEntity<MovieResponseDto> addMovie(@RequestBody @Valid MovieRequestDto movieRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movieRequestDto));
    }

    // GET API -> Fetch all movies
    // URL: GET /movie
    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovie(){
        return ResponseEntity.ok(movieService.getAllMovie());
    }

    // GET API -> Fetch movie by id
    // URL: GET /movie/{id}
    @GetMapping("{id}")
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable int id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    // DELETE API -> Delete movie by id
    // URL: DELETE /movie/{id}
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        movieService.deleteById(id);
    return ResponseEntity.ok("Movie Deleted successfuly with id"+id);
    }

    // PUT API -> Update movie details by id
    // URL: PUT /movie/{id}
    @PutMapping("{id}")
    public ResponseEntity<MovieResponseDto> updateMovie(@PathVariable int id , @Valid @RequestBody MovieRequestDto movieRequestDto){
        return ResponseEntity.ok(movieService.updateMovie(id,movieRequestDto));
    }



}
