package com.freelance.movie_api.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMovieNotFoundException(MovieNotFoundException ex, HttpServletRequest request){
    ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now(),
        HttpStatus.NOT_FOUND.value(),
        ex.getMessage(),
        request.getRequestURL().toString()
    );
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }


}
