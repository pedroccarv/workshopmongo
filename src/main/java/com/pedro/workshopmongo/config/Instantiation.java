package com.pedro.workshopmongo.config;

import com.pedro.workshopmongo.domain.Post;
import com.pedro.workshopmongo.domain.User;
import com.pedro.workshopmongo.dto.AuthorDTO;
import com.pedro.workshopmongo.repository.PostRepository;
import com.pedro.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User pedro = new User(null, "Pedro Carvalho", "pedro@gmail.com");
        User kaio = new User(null, "Kaio Jorge", "kaio@gmail.com");
        User matheus = new User(null, "Matheus Pereira", "matheus@gmail.com");
        userRepository.saveAll(Arrays.asList(pedro, kaio, matheus));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Sao Paulo abracos!", new AuthorDTO(pedro));
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(pedro));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
