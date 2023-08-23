package rodrigosrb.myfirstapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rodrigosrb.myfirstapi.model.User;
import rodrigosrb.myfirstapi.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{username}")
    public User getOne(@PathVariable("username") String username){
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postUser(@RequestBody User user){
        userRepository.save(user);
    }

}
