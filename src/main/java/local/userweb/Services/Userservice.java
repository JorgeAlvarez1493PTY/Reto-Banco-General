package local.userweb.Services;

import local.userweb.Entities.*;
import local.userweb.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import javax.transaction.Transactional;
@Service
@Transactional
public class Userservice {
    @Autowired
    private UserJpa userRepository;
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

      public List<User> findbyname(String text, String textAgain) {
      return userRepository.findByNombreContainingOrApellidoContaining(text, textAgain);
      }

      
}

