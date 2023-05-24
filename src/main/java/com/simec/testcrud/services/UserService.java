package com.simec.testcrud.services;

import com.simec.testcrud.models.User;
import com.simec.testcrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers (){
        List<User> users = userRepository.findAll();
        return users;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void delete (Long id){
        userRepository.deleteById(id);
    }

    public void update(User user){
        userRepository.save(user);
    }

    public Long findUserById (Long id){
        userRepository.findById(id);
        return id;
    }

    public void deleteById (Long id){
        userRepository.deleteById(id);
    }


    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
