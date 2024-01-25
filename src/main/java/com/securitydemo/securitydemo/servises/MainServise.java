package com.securitydemo.securitydemo.servises;

import com.securitydemo.securitydemo.utilities.AutheticationUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MainServise {
    public int calculateMean(int x , int y){

        return (x+y)/2;
    }
}
