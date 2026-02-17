<<<<<<< HEAD
package com.freelance.movie_api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelmapper(){
        return new ModelMapper();
    }
}
=======
package com.freelance.movie_api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelmapper(){
        return new ModelMapper();
    }
}
>>>>>>> 86fa909a0d62f6b9ca5feb7c6be4b8fa0ca916c8
