package com.spingboot.backendDemo1.service;


import com.spingboot.backendDemo1.repository.UserRepository;
import com.spingboot.backendDemo1.entity.User;
import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.exception.UserException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByEmail(String email){
       return repository.findByEmail(email);
    }

    public User update(User user){
        return repository.save(user);
    }

    public User updateName(String id, String name) throws UserException {
        Optional<User> opt = repository.findById(id);
        if(opt.equals(null)){
            throw UserException.notFound();
        }
        User user = opt.get();
        user.setName(name);

        return repository.save(user);
    }

    @CacheEvict(value = "user", key = "#id")
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @CacheEvict(value = "user", allEntries = true)
    public void deleteAll() {

    }

    public boolean matchPassword(String rawPassword, String encodedPassword){
        return passwordEncoder.matches(rawPassword, encodedPassword);
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
