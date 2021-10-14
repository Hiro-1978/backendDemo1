package com.spingboot.backendDemo1.service;


import com.spingboot.backendDemo1.repository.UserRepository;
import com.spingboot.backendDemo1.entity.User;
import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.exception.UserException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
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
        entity.setPassword(passwordEncoder.encode(password));
        entity.setName(name);

        return repository.save(entity);
    }
}
