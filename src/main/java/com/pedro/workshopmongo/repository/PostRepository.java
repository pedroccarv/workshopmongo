package com.pedro.workshopmongo.repository;

import com.pedro.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{'title':  { $regex:  ?0, $option:  'i'}}")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

}
