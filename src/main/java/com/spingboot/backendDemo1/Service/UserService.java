package com.spingboot.backendDemo1.Service;


import com.spingboot.backendDemo1.Repository.UserRepository;
import com.spingboot.backendDemo1.entity.User;
import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.exception.UserException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    //Function Create User
    public User create(String email, String password, String name) throws BaseException {
        // validate
        if (Objects.isNull(email)) {
            // throw error email null
            throw UserException.createEmailNull();
        }
        if (Objects.isNull(password)) {
            // throw error password null
            throw UserException.createPasswordNull();
        }
        if (Objects.isNull(name)) {
            // throw error name null
            throw UserException.createNameNull();
        }

        // verify
        if (repository.existsByEmail(email)) { //ถ้าเกิด email ซ้ำ
            throw UserException.createEmailDuplicated();
        }


        //save
        User entity = new User();
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setName(name);

        return repository.save(entity);
    }
}
