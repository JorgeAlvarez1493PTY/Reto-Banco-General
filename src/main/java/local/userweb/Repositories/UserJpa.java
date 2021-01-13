package local.userweb.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import local.userweb.Entities.User;


@Repository

public interface UserJpa  extends JpaRepository <User, Integer> {

	List<User> findByNombreContainingOrApellidoContaining(String text, String textAgain);

  


    
}
 
    

