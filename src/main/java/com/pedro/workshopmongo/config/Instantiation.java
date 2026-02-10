package com.pedro.workshopmongo.config;

import com.pedro.workshopmongo.domain.User;
import com.pedro.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User pedro = new User(null, "Pedro Carvalho", "pedro@gmail.com");
        User kaio = new User(null, "Kaio Jorge", "kaio@gmail.com");
        User matheus = new User(null, "Matheus Pereira", "matheus@gmail.com");

        userRepository.saveAll(Arrays.asList(pedro, kaio, matheus));

    }
}
