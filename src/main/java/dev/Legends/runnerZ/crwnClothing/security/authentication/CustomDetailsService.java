package dev.Legends.runnerZ.crwnClothing.security.authentication;

import dev.Legends.runnerZ.crwnClothing.security.register.RoleEntity;
import dev.Legends.runnerZ.crwnClothing.security.register.UserEntity;
import dev.Legends.runnerZ.crwnClothing.security.register.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomDetailsService implements UserDetailsService {
    public final UserRepository userRepository;
    //public final  UserDetails userDetails;
    public CustomDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(email.toLowerCase()).orElseThrow(()->new UsernameNotFoundException("User not found"));

        Set<String> userRoles = user.getRoles().stream().map(RoleEntity::getRoleName).collect(Collectors.toSet());

        Set<SimpleGrantedAuthority> authorities = userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toSet());

        System.out.println("Roles: " + userRoles);
        System.out.println("Authorities: " + authorities);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

}
