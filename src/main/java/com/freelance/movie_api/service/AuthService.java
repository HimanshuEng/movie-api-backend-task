package com.freelance.movie_api.service;

import com.freelance.movie_api.dto.LoginRequestDto;
import com.freelance.movie_api.dto.LoginResponseDto;
import com.freelance.movie_api.dto.RegisterRequestDto;
import com.freelance.movie_api.dto.RegisterRespondeDto;
import org.jspecify.annotations.Nullable;


public interface AuthService {


    RegisterRespondeDto register(RegisterRequestDto registerRequestDto) ;


    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
