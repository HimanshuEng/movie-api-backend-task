package com.freelance.movie_api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;


public class MovieRequestDto {

    // Movie title (Example: "KGF", "Avengers")
    @NotBlank(message = "Title is required")
    private String title;

    // Short description about movie
    @NotBlank(message = "Description is required")
    private String description;

    // Movie genre (Example: Action, Drama, Comedy)
    @NotBlank(message = "Genre is required")
    private String genre;

    // Movie rating (Example: 1 to 5 or 1 to 10)
    @NotNull(message = "Rating is required")
    @Min(1)
    @Max(10)
    private Long rating;

    private MultipartFile banner;

    // Default constructor
   public MovieRequestDto() {
    }

    // Parameterized constructor


    public MovieRequestDto(String title, String description, String genre, Long rating, MultipartFile banner) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.banner = banner;
    }

    // Getter and Setter methods
    public MultipartFile getBanner() {
        return banner;
    }

    public void setBanner(MultipartFile banner) {
        this.banner = banner;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Long getRating() {
        return rating;
    }
    public void setRating(Long rating) {
        this.rating = rating;
    }
}
