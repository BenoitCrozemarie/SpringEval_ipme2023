package fr.crozemarie.ipme.exerciceSpring.repositories;

import fr.crozemarie.ipme.exerciceSpring.pojos.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
