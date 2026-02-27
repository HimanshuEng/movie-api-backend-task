
package com.freelance.movie_api.exception;


public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String message){
        super(message);
    }
}
