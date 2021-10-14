package com.spingboot.backendDemo1.repository;

import com.spingboot.backendDemo1.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByEmail(String email); //เขียนคำสั่งค้นหาเพิ่มจาก Email

    boolean existsByEmail(String email);

}
