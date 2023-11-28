package com.example.demo.Service;

import com.example.demo.Models.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public User findbyId(Long id){
        return userRepository.getOne(id);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
       return userRepository.save(user);

    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
