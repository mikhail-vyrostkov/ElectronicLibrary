package ru.vyrostkov.project1.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by @m.vyrostkov on 25.03.2023 13:12
 */
@Component
@RequestMapping("/")
public class StartController {


    @GetMapping
    public String getStartPage() {
        return "startpage";
    }
}
