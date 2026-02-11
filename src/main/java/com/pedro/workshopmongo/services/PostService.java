package com.pedro.workshopmongo.services;

import com.pedro.workshopmongo.domain.Post;
import com.pedro.workshopmongo.repository.PostRepository;
import com.pedro.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Post> findbyTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

}
