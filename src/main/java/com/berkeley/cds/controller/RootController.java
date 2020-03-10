package com.berkeley.cds.controller;

import com.berkeley.cds.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @Autowired
    private CounterService service;

    @RequestMapping("/")
    public String index(final Model model)
    {
        String counter = service.incrementCounter();
        model.addAttribute("counter", counter);
        return "index";
    }
}
