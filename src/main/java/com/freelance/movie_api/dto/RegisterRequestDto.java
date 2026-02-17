package com.freelance.movie_api.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


public class RegisterRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invaild email formate")
    @NotBlank
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
            message = "Password must contain 1 uppercase, 1 lowercase, 1 number, 1 special character and minimum 8 characters"
    )
    private String password;

    public @NotBlank(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") String name) {
        this.name = name;
    }

    public @Email(message = "Invaild email formate") @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invaild email formate") @NotBlank String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is required") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
            message = "Password must contain 1 uppercase, 1 lowercase, 1 number, 1 special character and minimum 8 characters"
    ) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
            message = "Password must contain 1 uppercase, 1 lowercase, 1 number, 1 special character and minimum 8 characters"
    ) String password) {
        this.password = password;
    }

    public RegisterRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public RegisterRequestDto() {

    }
}
