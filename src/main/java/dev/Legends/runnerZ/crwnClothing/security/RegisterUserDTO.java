package dev.Legends.runnerZ.crwnClothing.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.Legends.runnerZ.crwnClothing.RoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Set;


public class RegisterUserDTO {
    @NotBlank(message = "Email must not be empty")
    @Size(max = 50, message = "Email cannot exceed 50 character")
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    @NotBlank(message = "Email must not be empty")
    @Size(max = 50, message = "Email cannot exceed 50 character")
    private String lastName;

    @JsonProperty("email")
    @NotBlank(message = "Email must not be empty")
    @Size(max = 50, message = "Email cannot exceed 50 character")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "Password must not be empty")
    @Size(min = 8, message = "password must be greater than 8 character")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@])[A-Za-z\\d!@]{8,}$",
            message = "Password must have at least one uppercase, one lowercase, one digit, one special character (! or @), and be at least 8 characters long"
    )
    private String password;

    @JsonProperty("roles")
    @NotBlank(message = "must select the role")
    private Set<String> roles;
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }

//    @Override
//    public String toString() {
//        return "RegisterUserDTO{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", roles=" + roles +
//                '}';
//    }
}
