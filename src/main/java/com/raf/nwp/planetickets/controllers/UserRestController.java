package com.raf.nwp.planetickets.controllers;

import com.raf.nwp.planetickets.model.MyUser;
import com.raf.nwp.planetickets.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MyUser> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MyUser createUser(@RequestBody MyUser myUser) {
        return userService.save(myUser);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MyUser updateUser(@RequestBody MyUser myUser) {
        return userService.save(myUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<MyUser> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()) {
            //TODO dodaj da se brise sta bude trebalo
            userService.deleteById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
