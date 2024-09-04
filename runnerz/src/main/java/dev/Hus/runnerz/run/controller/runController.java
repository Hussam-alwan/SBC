package dev.Hus.runnerz.run.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/runs")
public class runController {

    @GetMapping("/hello")
    String home(){
        return "hello Runners";
    }
}
