package com.cicdtestprojectdev.cicdtestprojectdev.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cicdapi")
public class CicdApi {

    @GetMapping("/message")
    private String message(){
        return "CI / CD Api is up";
    }
}
