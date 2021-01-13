package local.userweb.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jdk.jshell.spi.ExecutionControl.UserException;
import local.userweb.Repositories.UserJpa;
import local.userweb.Services.Userservice;
import local.userweb.Entities.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/users")
public class Usercontroller {

    @Autowired
    Userservice userservice;

    @GetMapping("")
    public List<User> index() {
        return userservice.listAllUser();
    }

    @GetMapping("/{id}")
    public User show(@PathVariable String id) {
        int userid = Integer.parseInt(id);
        return userservice.getUser(userid);
    }

    @PostMapping("/search")
    public List<User> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return userservice.findbyname(searchTerm, searchTerm);
    }
   
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public void add(@RequestBody User user){
         userservice.saveUser(user);
    }
 
    

    @PutMapping("/{id}")
      public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existUser = userservice.getUser(id);
            user.setId(id);            
            userservice.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        int userid = Integer.parseInt(id);
        userservice.deleteUser(userid);
        return true;
    }

} 

