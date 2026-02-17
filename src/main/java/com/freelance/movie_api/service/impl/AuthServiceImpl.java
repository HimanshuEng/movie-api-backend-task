package com.freelance.movie_api.service.impl;

import com.freelance.movie_api.config.MapperConfig;
import com.freelance.movie_api.dto.LoginRequestDto;
import com.freelance.movie_api.dto.LoginResponseDto;
import com.freelance.movie_api.dto.RegisterRequestDto;
import com.freelance.movie_api.dto.RegisterRespondeDto;
import com.freelance.movie_api.entity.User;
import com.freelance.movie_api.repository.UserRepository;
import com.freelance.movie_api.service.AuthService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public AuthServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RegisterRespondeDto register(RegisterRequestDto registerRequestDto) {
            if(userRepository.existsByEmail(registerRequestDto.getEmail())){
                throw new RuntimeException("Email already registered!");
    }

            // Dto -> Entity
           User user =  modelMapper.map(registerRequestDto, User.class);

        // Set role and createdAt manually
        user.setRole("USER");
        user.setCreatedAt(LocalDateTime.now());

           User saveUser =  userRepository.save(user);
            //Entity -> Dto
       RegisterRespondeDto respondeDto =  modelMapper.map(saveUser,RegisterRespondeDto.class);
        respondeDto.setMessage("User registered successfully");
        return respondeDto;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
      User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow(()-> new RuntimeException("Invaild Email"));

      if(!user.getPassword().equals(loginRequestDto.getPassword())){
          throw new RuntimeException("Invail Password");
      }

        LoginResponseDto loginResponseDto = modelMapper.map(user,LoginResponseDto.class);
            loginResponseDto.setMessage("Login Successful");

            return loginResponseDto;
    }

}
