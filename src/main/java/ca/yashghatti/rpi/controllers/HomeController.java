package ca.yashghatti.rpi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) throws IOException {
        model.addAttribute("appVersion","v0.1");

        ProcessBuilder proc = new ProcessBuilder("vcgencmd","measure_temp");
        Process pr = proc.start();
        String output = new String(pr.getInputStream().readAllBytes());
        String err = new String(pr.getErrorStream().readAllBytes());
        System.out.println("-----------");
        System.out.println(output);
        System.out.println(err);


        model.addAttribute("deviceTemp",output);
        return "index";
    }

}
