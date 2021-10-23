package com.spingboot.backendDemo1.repository;

import com.spingboot.backendDemo1.entity.Address;
import com.spingboot.backendDemo1.entity.Social;
import com.spingboot.backendDemo1.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, String> {

    List<Address> findByUser(User user);

}
