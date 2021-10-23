package com.spingboot.backendDemo1.repository;

import com.spingboot.backendDemo1.entity.Social;
import com.spingboot.backendDemo1.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SocialRepository extends CrudRepository<Social, String> {

    Optional<Social> findByUser(User user);

}
