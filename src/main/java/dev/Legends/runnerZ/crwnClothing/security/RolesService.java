package dev.Legends.runnerZ.crwnClothing.security;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {


    private final RoleRepository roleRepository;

    @Autowired
    public RolesService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void fetchRoles() {
        RoleEntity role = new RoleEntity();
        role.setRoleName("ADMIN");
        roleRepository.save(role);
        System.out.println("Roles: " + roleRepository.findAll());
    }


}