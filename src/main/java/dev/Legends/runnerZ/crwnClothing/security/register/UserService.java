package dev.Legends.runnerZ.crwnClothing.security.register;

import dev.Legends.runnerZ.crwnClothing.utils.ApiResponse;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public final ModelMapper modelMapper;
    private  static final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder
    ,ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;

    }

    public ApiResponse<UserResponseDTO> registerUser(RegisterUserDTO registerUserDTO) {


        // Check if user already exists
        if (userRepository.findByEmail(registerUserDTO.getEmail().toLowerCase()).isPresent()) {
            throw new RuntimeException("User already exists!");
        }
        System.out.println(roleRepository.findAll());
        //System.out.println(roleRepository.findByRoleName("ADMIN"));

        // Fetch role from DB (default is USER role)
       Set<RoleEntity> userRoles = roleRepository.findByRoleNameIn(registerUserDTO.getRoles()).orElseThrow(() -> new RuntimeException("Role not found"));

        System.out.println(userRoles);
        // Create new User entity
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(registerUserDTO.getFirstName());
        userEntity.setLastName(registerUserDTO.getLastName());
        userEntity.setEmail(registerUserDTO.getEmail().toLowerCase());
        userEntity.setPassword(passwordEncoder.encode(registerUserDTO.getPassword())); // Encrypt password
        userEntity.setRoles(userRoles); // Assign Role
        UserEntity createdUser = userRepository.save(userEntity);// Save user
        Set<String> createdRoles = createdUser.getRoles().stream().map(RoleEntity::getRoleName).collect(Collectors.toSet());
        UserResponseDTO user = modelMapper.map(createdUser,UserResponseDTO.class);
        user.setRoles(createdRoles);
        return new ApiResponse<UserResponseDTO>(user, HttpStatus.CREATED.value(),"User created");



    }

}
