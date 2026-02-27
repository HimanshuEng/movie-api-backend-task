package com.freelance.movie_api.service.impl;

import com.freelance.movie_api.dto.MovieRequestDto;
import com.freelance.movie_api.dto.MovieResponseDto;
import com.freelance.movie_api.entity.Movie;
import com.freelance.movie_api.exception.MovieNotFoundException;
import com.freelance.movie_api.repository.MovieRepository;
import com.freelance.movie_api.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service // Marks this class as Service Layer component
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    // Constructor Injection
    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public MovieResponseDto addMovie(MovieRequestDto movieRequestDto) {
            Movie movie = modelMapper.map(movieRequestDto,Movie.class);
            Movie  saved = movieRepository.save(movie);
            return  modelMapper.map(saved,MovieResponseDto.class);
    }

    @Override
    public MovieResponseDto getMovieById(int id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not  Found "+id));
        return modelMapper.map(movie,MovieResponseDto.class);
    }

    @Override
    public List<MovieResponseDto> getAllMovie() {
        return movieRepository.findAll().stream().map(movie -> modelMapper.map(movie,MovieResponseDto.class)).toList();

    }

    @Override
    public boolean deleteById(int id) {
       Movie movie =  movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException("Movie Not Found By Id "+id));
       movieRepository.delete(movie);
        return true;
    }

    @Override
    public MovieResponseDto updateMovie(int id, MovieRequestDto movieRequestDto) {
        Movie existingMovie  = movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException("Movie Not Found"+id));

        existingMovie.setTitle(movieRequestDto.getTitle());
        existingMovie.setDescription(movieRequestDto.getDescription());
        existingMovie.setGenre(movieRequestDto.getGenre());
        existingMovie.setRating(movieRequestDto.getRating());

        Movie updateMovie = movieRepository.save(existingMovie);
        return modelMapper.map(updateMovie,MovieResponseDto.class);
    }


//    // Add movie logic
//    @Override
//    public MovieResponseDto addMovie(MovieRequestDto movieRequestDto) {
//      Movie  movie = modelMapper.map( movieRequestDto , Movie.class);
//      Movie newMovie =  movieRepository.save(movie);
//      return modelMapper.map(newMovie,MovieResponseDto.class);
//    }
//
//    // Fetch movie by id
//    @Override
//    public MovieResponseDto getMovieById(int id) {
//        Movie movie = movieRepository.findById(id);
//        if(movie == null){
//            throw new  MovieNotFoundException("Movie Not Found With Id : "+id);
//        }
//        return modelMapper.map(movie,MovieResponseDto.class);
//    }
//
//    // Fetch all movies
//    @Override
//    public List<MovieResponseDto> getAllMovie() {
//        List<Movie> movie = movieRepository.findAll();
//        List<MovieResponseDto> list = new ArrayList<>();
//        for(Movie movie1 :  movie ){
//       MovieResponseDto dto = modelMapper.map(movie1, MovieResponseDto.class);
//        list.add(dto);
//        }
//         return list;
//    }
//
//    // Delete movie by id
//    @Override
//    public boolean deleteById(int id) {
//      Movie movie   = movieRepository.findById(id);
//        if (movie==null){
//         throw new IllegalArgumentException("Movie Not Found With Id : "+id);
//        }
//        return movieRepository.deleteById(id);
//    }
//
//    // Update movie by id
//    @Override
//    public MovieResponseDto updateMovie(int id, MovieRequestDto movieRequestDto) {
//        Movie existingMovie = movieRepository.findById(id);
//        if (existingMovie==null){
//            throw  new MovieNotFoundException("Movie Not Found With Id : "+id);
//        }
//        existingMovie.setTitle(movieRequestDto.getTitle());
//        existingMovie.setDescription(movieRequestDto.getDescription());
//        existingMovie.setGenre(movieRequestDto.getGenre());
//        existingMovie.setRating(movieRequestDto.getRating());
//        return modelMapper.map(existingMovie,MovieResponseDto.class);
//    }

}

