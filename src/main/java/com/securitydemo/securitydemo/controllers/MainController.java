package com.securitydemo.securitydemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class MainController {
    @GetMapping(path = "getdata")
    public ResponseEntity<String> getData(){
        try{
            return ResponseEntity.ok().body("This is from the api all good");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }

    }
}
