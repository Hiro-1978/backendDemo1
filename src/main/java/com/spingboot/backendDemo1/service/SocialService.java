package com.spingboot.backendDemo1.service;


import com.spingboot.backendDemo1.entity.Social;
import com.spingboot.backendDemo1.entity.User;
import com.spingboot.backendDemo1.repository.SocialRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocialService {

    private SocialRepository repository;

    public SocialService(SocialRepository repository) {
        this.repository = repository;
    }

    public Optional<Social> findByUser(User user) {
        return repository.findByUser(user);
    }

    public Social create(User user,String facebook,String line,String instagram,String tiktok){
        //Todo : validate

        //Create
        Social entity = new Social();
        entity.setUser(user);
        entity.setFacebook(facebook);
        entity.setLine(line);
        entity.setInstagram(instagram);
        entity.setTiktok(tiktok);

        return repository.save(entity);
    }

}
