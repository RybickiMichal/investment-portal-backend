package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.User;
import com.rybicki.investmentportal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addNewUser(User newUser){
        userRepository.save(newUser);
    }

    public boolean userExists(String username){
        List<User> users= userRepository.findAll();
        for(User user: users){
            if(username.equals(user.getUsername())){
                return true;
            }
        }
        return false;
    }
}
