package com.pedro.workshopmongo.resources;

import com.pedro.workshopmongo.domain.Post;
import com.pedro.workshopmongo.repository.PostRepository;
import com.pedro.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

}
