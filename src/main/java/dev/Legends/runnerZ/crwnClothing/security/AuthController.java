package dev.Legends.runnerZ.crwnClothing.security;

import dev.Legends.runnerZ.crwnClothing.utils.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authentication")
public class AuthController {


    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    public final UserRepository userRepository;
    public final CustomerDetailsService customerDetailsService;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

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

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO,HttpServletRequest request) {
////        UserDetails user = customerDetailsService.loadUserByUsername("test@example.com");
////        System.out.println(user);
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
//        );
//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//        context.setAuthentication(authentication);
//        SecurityContextHolder.setContext(context);
//
//        // Store in session
//        request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", context);
//        if (authentication != null) {
//            System.out.println("Authenticated user: " + authentication.getName());
//            System.out.println("Session ID: " + request.getSession().getId());
//        } else {
//            System.out.println("No authentication found.");
//        }
//        return ResponseEntity.ok("Logged in");
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
//        // Get the current authenticated user
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        // Log the user name for debugging
//        System.out.println("Authenticated user: " + (auth != null ? auth.getName() : "None"));
//
//        if (auth != null) {
//            // Invalidate the session and clear the SecurityContext
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//
//            // Clear the SecurityContext after logout
//            SecurityContextHolder.clearContext();
//
//            // Invalidate the session
//            request.getSession().invalidate();
//
//            // Optionally, you can also redirect or send a custom message after logout
//            return ResponseEntity.ok("User logged out successfully");
//        }
//
//        // If the user is not authenticated, return forbidden status
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User not authenticated");
//    }
//
//    @GetMapping("/session-check")
//    public ResponseEntity<?> checkSession(HttpSession session) {
//        log.info("Session ID: {}", session.getId());
//        log.info("Security Context: {}", SecurityContextHolder.getContext().getAuthentication());
//        return ResponseEntity.ok("Session Active");
//    }
}
