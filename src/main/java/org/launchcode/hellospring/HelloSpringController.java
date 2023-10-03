package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloSpringController {

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})

    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, "+name+"!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")

    public String helloAgain(@PathVariable String name,Model model) {
        String greeting = "Hello, "+name+"!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
       return "form";
    }

    @GetMapping("hello-names")
    public String helloName(Model model){
        List<String> names = new ArrayList<>();
        names.add("Launchcode");
        names.add("Java");
        names.add("Javascript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}