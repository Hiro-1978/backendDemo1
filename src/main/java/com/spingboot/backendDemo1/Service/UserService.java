package com.spingboot.backendDemo1.Service;


import com.spingboot.backendDemo1.Repository.UserRepository;
import com.spingboot.backendDemo1.entity.User;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    //Function Create User
    public User create(String email, String password, String name){
        // validate
        if(Objects.isNull(email)){
            // throw error email null
        }
        if(Objects.isNull(password)){
            // throw error password null
        }
        if(Objects.isNull(name)){
            // throw error name null
        }

        // verify


        //save
        User entity = new User();
        entity.setEmail(email);
        entity.setPassword(password);

        return repository.save(entity);
    }
}
