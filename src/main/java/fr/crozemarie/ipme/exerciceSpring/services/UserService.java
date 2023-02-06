package fr.crozemarie.ipme.exerciceSpring.services;

import fr.crozemarie.ipme.exerciceSpring.exceptions.RoleNotDefinedException;
import fr.crozemarie.ipme.exerciceSpring.exceptions.UniqueDataException;
import fr.crozemarie.ipme.exerciceSpring.pojos.User;
import fr.crozemarie.ipme.exerciceSpring.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GeneriqueService<User>{
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        setRepo(userRepository);
    }

    @Override
    public User save(User updated) {
        if( userRepository.findByName(updated.getName()).isPresent() ){
            logger.warn("Trying to insert a no unique user name");
            throw new UniqueDataException();
        }
        if(updated.getRole() == null){
            logger.warn("Trying to insert a no role user ");
            throw new RoleNotDefinedException();
        }
        return jpaRepository.save(updated);
    }
}
