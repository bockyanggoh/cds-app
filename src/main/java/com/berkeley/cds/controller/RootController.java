package com.berkeley.cds.controller;

import com.berkeley.cds.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    private final CounterService service;

    @Autowired
    public RootController(CounterService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(final Model model)
    {
        String counter = service.incrementCounter();
        model.addAttribute("counter", counter);
        return "index";
    }
}
