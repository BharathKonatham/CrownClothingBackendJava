package dev.Legends.runnerZ.crwnClothing.security.authentication;

import dev.Legends.runnerZ.crwnClothing.security.register.RegisterUserDTO;
import dev.Legends.runnerZ.crwnClothing.security.register.UserRepository;
import dev.Legends.runnerZ.crwnClothing.security.register.UserResponseDTO;
import dev.Legends.runnerZ.crwnClothing.security.register.UserService;
import dev.Legends.runnerZ.crwnClothing.utils.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/authentication")
public class AuthController {


    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    public final UserRepository userRepository;
    //public final CustomDetailsService customerDetailsService;
    public final JwtUtils jwtUtils;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    //CustomDetailsService customerDetailsService,
    public AuthController(UserService userService, AuthenticationManager authenticationManager,UserRepository userRepository,JwtUtils jwtUtils ) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
//        this.customerDetailsService = customerDetailsService;
    }

    @PostMapping("/register")
    public ApiResponse<UserResponseDTO> register(@RequestBody RegisterUserDTO registerUserDTO) {
        log.info(registerUserDTO.toString());
        return userService.registerUser(registerUserDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {

        Authentication authentication;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        } catch (AuthenticationException exception) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        //UserDetails userDetails = customerDetailsService.loadUserByUsername(loginDTO.getEmail());
        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();
//                .collect(Collectors.toList());

        LoginResponse response = new LoginResponse(userDetails.getUsername(), roles, jwtToken);

        return ResponseEntity.ok(response);
//        return ResponseEntity.ok("Logged in");
    }

}
