package ru.vyrostkov.ElectronicLibraryWithBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by @m.vyrostkov on 25.03.2023 13:12
 */
@Controller
public class StartController {


    @GetMapping("/startpage")
    public String getStartPage() {
        return "startpage";
    }
}
