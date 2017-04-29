package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity<String> wellcome() {
        return new ResponseEntity<String>("<h1>Welcome the this example.</h1>", HttpStatus.OK);
    }

    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user) {
        User userData = userRepository.save(user);
        return new ResponseEntity<User>(userData, HttpStatus.OK);
    }
    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathParam(value="id") long id) {
        userRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@RequestBody User user) {
        return save(user);
    }
}
