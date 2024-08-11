package com.embarkx.FirstSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/123")
    public HelloResponse hello(){
        return new HelloResponse("hello Hussam");
    }
    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "Hello Post "+ name+"!";
    }


}
