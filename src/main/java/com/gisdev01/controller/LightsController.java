package com.gisdev01.controller;

import com.gisdev01.model.RasPi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LightsController {

    RasPi raspi1 = new RasPi();

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/turnlightson", method = RequestMethod.POST)
    public void turnLightsOn()
    {
        System.out.println("Hit endpoint to turn lights on.");
        //raspi1.turnLightsOn();
    }

    @RequestMapping(value = "/turnlightsoff", method = RequestMethod.POST)
    public void turnLightsOff()
    {
        System.out.println("Hit endpoint to turn lights off.");
        //raspi1.turnLightsOff();

    }


}
