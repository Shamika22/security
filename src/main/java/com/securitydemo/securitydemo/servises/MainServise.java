package com.securitydemo.securitydemo.servises;

import com.securitydemo.securitydemo.utilities.AutheticationUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MainServise {
    private AutheticationUtilities authUtilities;
    public int calculateMean(int x , int y){

        SecurityContext theContext = SecurityContextHolder.getContext();
        Authentication resourseOwner = theContext.getAuthentication();
        System.out.println(resourseOwner.getName());
        System.out.println(resourseOwner.getCredentials());
        System.out.println(resourseOwner.getDetails());
        System.out.println(resourseOwner.getAuthorities());
        System.out.println(resourseOwner.getPrincipal());

        authUtilities.getUserId(resourseOwner.getName());

        return (x+y)/2;
    }
}
