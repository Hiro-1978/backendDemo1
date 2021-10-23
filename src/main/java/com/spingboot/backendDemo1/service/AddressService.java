package com.spingboot.backendDemo1.service;


import com.spingboot.backendDemo1.entity.Address;
import com.spingboot.backendDemo1.entity.Social;
import com.spingboot.backendDemo1.entity.User;
import com.spingboot.backendDemo1.repository.AddressRepository;
import com.spingboot.backendDemo1.repository.SocialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> findByUser(User user) {
        return repository.findByUser(user);
    }

    public Address create(User user,String line1,String line2,String zipcode){
        //Todo : validate

        //Create
        Address entity = new Address();
        entity.setUser(user);
        entity.setLine1(line1);
        entity.setLine2(line2);
        entity.setZipcode(zipcode);

        return repository.save(entity);
    }

}
