package com.example.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//The Spring 4 @RestController annotation that basically annotates all methods with @ResponseBody
// to specify that we’ll be returning JSON objects.
@RestController
//@Controller
//@RequestMapping(SecureRestController.API)
@RequestMapping("/api")
public class SecureRestController {

    //public static final String API = "/api";

    @RequestMapping("/users")
    public String authorized() {

        return "Hello Secured World";
    }

    /*@RequestMapping(value = "/welcome", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> find() {

        String result = "Welcome to Spring Boot";

        return ResponseEntity.ok().body(result);
    }*/

}
