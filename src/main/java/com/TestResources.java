package com;

import obj.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class TestResources {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/")
    public String root() {
        return "root page";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/myfirstname")
    public String getMyFirstName() {
        // call ratings api to get all ratings, using user ID
        Person john = webClientBuilder.build()
                .get()
                .uri("https://jmt-test-app.herokuapp.com/john")
                .retrieve()
                .bodyToMono(Person.class)
                .block();
        return john.getFirstName();
    }

    @GetMapping("/mylastname")
    public String getMyLastName() {
        // call ratings api to get all ratings, using user ID
        Person john = webClientBuilder.build()
                .get()
                .uri("https://jmt-test-app.herokuapp.com/john")
                .retrieve()
                .bodyToMono(Person.class)
                .block();
        return john.getFirstName();
    }
}
