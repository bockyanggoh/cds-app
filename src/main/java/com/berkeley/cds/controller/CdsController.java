package com.berkeley.cds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cds")
public class CdsController {
    @GetMapping
    public ResponseEntity RetrieveCdsCount() {
        return ResponseEntity.ok(1);
    }

    @PostMapping
    public ResponseEntity IncrementCdsCountApi() {
        return ResponseEntity.ok(2);
    }

}
