package com.wildcodeschool.myProjectWithSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String hello() {
        return "Welcome to the shield";
    }
    
    
    @GetMapping("/avengers/assemble")
    public String assemble() {
    	return "Avergers... Assemble";
    }
    
    
    @GetMapping("/secret-base")
    public String secretBases() {    	
    	return "Amsterdam, Barcelone, Berlin, Biarritz, Bordeaux, Bruxelles, Bucarest, La Loupe, Lille, Lisbonne, Londes, Lyon, Madrid, Marseille, Nantes, Orléans, Paris, Reims, Strasbourg, Toulouse, Tours";
    }
}