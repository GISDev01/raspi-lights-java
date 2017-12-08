package com.gisdev01.core;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/")
    String homepage() {
        return "Web App Front end placeholder";
    }

    @RequestMapping(value = "/turnlightson", method = RequestMethod.POST)
    public void turnLightsOn()
    {
        System.out.println("Turning lights on.");

    }

    @RequestMapping(value = "/turnlightsoff", method = RequestMethod.POST)
    public void turnLightsOff()
    {
        System.out.println("Turning lights off.");

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
