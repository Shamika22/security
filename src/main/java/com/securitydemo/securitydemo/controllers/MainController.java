package com.securitydemo.securitydemo.controllers;

import com.securitydemo.securitydemo.servises.MainServise;
import com.securitydemo.securitydemo.utilities.AutheticationUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class MainController {

    private final MainServise theMainService;
    private final AutheticationUtilities theAuthService;

    public MainController(MainServise theMainServiceIn , AutheticationUtilities theAuthUtilIn){
        this.theMainService = theMainServiceIn;
        this.theAuthService = theAuthUtilIn;
    }

    @GetMapping(path = "getdata")
    public ResponseEntity<String> getData(){
        try{

            int result = theMainService.calculateMean(8,10);
            SecurityContext theContext = SecurityContextHolder.getContext();
            Authentication resourseOwner = theContext.getAuthentication();
            System.out.println(resourseOwner.getName());
            theAuthService.getUserId(resourseOwner.getName());
            return ResponseEntity.ok().body("This is from the api all good result is" + result);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }

    }
}
