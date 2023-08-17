package com.example.got.controller;

import com.example.got.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PoemController {
    private final PoemService poemService;
    @Autowired
    public PoemController(PoemService poemService) {
        this.poemService = poemService;
    }
    @GetMapping("/poem/{description}")
    public String getPoem(@PathVariable String description) {
        return poemService.getPoem(description);
    }
}
