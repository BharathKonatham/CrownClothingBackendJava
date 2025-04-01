package dev.Legends.runnerZ.crwnClothing.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("command line runner");
        if (roleRepository.count() == 0) { // Only insert if no roles exist
            RoleEntity adminRole = new RoleEntity();
            adminRole.setRoleName("ROLE_ADMIN");

            RoleEntity userRole = new RoleEntity();
            userRole.setRoleName("ROLE_USER");

            roleRepository.saveAll(Set.of(adminRole, userRole));
            System.out.println("Inserted roles: " + roleRepository.findAll());
        } else {
            System.out.println("Roles already exist: " + roleRepository.findAll());
        }
    }
}
