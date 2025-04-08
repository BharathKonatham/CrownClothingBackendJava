package dev.Legends.runnerZ.crwnClothing.security.register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByRoleName(String roleName);
    Optional<Set<RoleEntity>> findByRoleNameIn(Set<String> roleNames);
}
