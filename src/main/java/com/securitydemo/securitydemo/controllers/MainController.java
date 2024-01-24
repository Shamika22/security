package com.securitydemo.securitydemo.controllers;

import com.securitydemo.securitydemo.servises.MainServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class MainController {
    @Autowired
    private MainServise theMainService;
    @GetMapping(path = "getdata")
    public ResponseEntity<String> getData(){
        try{

            int result = theMainService.calculateMean(8,10);
            return ResponseEntity.ok().body("This is from the api all good result is" + result);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }

    }
}
