package com.securitydemo.securitydemo.utilities;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class AutheticationUtilities {
    public String getUserId(String authPrincipal){
        String extractedNumber =null;
        // Define a regex pattern to match the number after the pipe character
        Pattern pattern = Pattern.compile("\\|(\\d+)");

        // Create a Matcher object
        Matcher matcher = pattern.matcher(authPrincipal);

        // Check if the pattern is found
        if (matcher.find()) {
            // Extract the matched number
            extractedNumber = matcher.group(1);
            System.out.println("Extracted Number: " + extractedNumber);
        } else {
            System.out.println("No match found");
        }
        return extractedNumber;
    }
}
