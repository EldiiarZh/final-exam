package edu.attractor.demo.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parking")
@AllArgsConstructor
public class ParkingController {
     @GetMapping()
    public String parking() {
         return "main/main";
     }
}
