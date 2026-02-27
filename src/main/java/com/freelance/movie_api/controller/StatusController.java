package com.freelance.movie_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // Marks this class as REST Controller (returns JSON/String response)
@RequestMapping("checkstatus")
public class StatusController {

    // GET API -> Used to check if application is running or not
    // URL: GET /checkstatus
    @GetMapping
    public String checkStatus(){
        return "Application Run successfully"; // Simple message response for testing server health
    }
}
