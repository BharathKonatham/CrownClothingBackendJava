package dev.Legends.runnerZ.crwnClothing.security;

import dev.Legends.runnerZ.crwnClothing.utils.ApiResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    public final UserRepository userRepository;
    public final CustomerDetailsService customerDetailsService;
    public AuthController(CustomerDetailsService customerDetailsService,UserService userService, AuthenticationManager authenticationManager,UserRepository userRepository ) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;

        this.customerDetailsService = customerDetailsService;
    }

    @PostMapping("/register")
    public ApiResponse<UserResponseDTO> register(@RequestBody RegisterUserDTO registerUserDTO) {
        System.out.println(registerUserDTO.toString());
        return userService.registerUser(registerUserDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
//        UserDetails user = customerDetailsService.loadUserByUsername("test@example.com");
//        System.out.println(user);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );
        return "User authenticated: " + authentication.isAuthenticated();
    }
}
