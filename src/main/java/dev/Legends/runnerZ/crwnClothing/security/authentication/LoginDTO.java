package dev.Legends.runnerZ.crwnClothing.security.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    @NotBlank(message = "Email must not be empty")
    @Size(max = 50, message = "Email cannot exceed 50 character")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    private String email;


    @NotBlank(message = "Password must not be empty")
    @Size(min = 8, message = "password must be greater than 8 character")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@])[A-Za-z\\d!@]{8,}$",
            message = "Password must have at least one uppercase, one lowercase, one digit, one special character (! or @), and be at least 8 characters long"
    )
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
