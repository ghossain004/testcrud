package com.simec.testcrud.controllers;

import com.simec.testcrud.models.Trainee;
import com.simec.testcrud.models.User;
import com.simec.testcrud.repositories.TraineeRepository;
import com.simec.testcrud.repositories.UserRepository;
import com.simec.testcrud.services.TraineeService;
import com.simec.testcrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    private List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> registerUser(@RequestBody User user) {
        HashMap<String, Object> response = new HashMap<>();
        Optional<User> existsUser = userService.findByUserName(user.getUserName());
        if (existsUser.isPresent()) {
            response.put("error", "User is already registered!");
            return response;
        }
        List<User> userList = new ArrayList<>();
        userService.save(user);
        response.put("message", "Successfully registered!");
        return response;
    }

    @GetMapping("/get/{id}")
    User getUser(@PathVariable("id") Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
    }

    @PutMapping("/update/{id}")
    private void updateUser(@RequestBody User user){
        userService.update(user);
    }
}
