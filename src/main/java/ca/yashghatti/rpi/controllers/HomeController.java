package ca.yashghatti.rpi.controllers;

import ca.yashghatti.rpi.utils.Executor;
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

        String output = Executor.runCmd("vcgencmd","measure_temp");
        model.addAttribute("deviceTemp",output);

        // $> cat /proc/stat for cpu usage stats


        return "index";
    }

}
