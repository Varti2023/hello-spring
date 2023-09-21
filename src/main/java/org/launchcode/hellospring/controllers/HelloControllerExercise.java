package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(value ="hello", method = RequestMethod.POST)
public class HelloControllerExercise {
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language-select' id='language-select'>" +
                "<option value='zh'>Chinese - 中文</option>"+
                "<option value='es'>Spanish - español</option>"+
                "<option value='en'>English</option>"+
                "<option value='fr'>French</option>"+
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String name, String lang){
        String message="";
        if(lang.equals("zh")){
            message = "你好";
        }else if (lang.equals("es")){
            message="Hola";
        }else if(lang.equals("en")){
            message="Hello";
        }else if(lang.equals("fr")){
            message="Bonjour";
        }
        return message +"!";
    }
}
