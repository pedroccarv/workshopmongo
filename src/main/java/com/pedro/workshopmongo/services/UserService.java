package com.pedro.workshopmongo.services;

import com.pedro.workshopmongo.domain.User;
import com.pedro.workshopmongo.repository.UserRepository;
import com.pedro.workshopmongo.resources.UserResource;
import com.pedro.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException(id));
    }
}
