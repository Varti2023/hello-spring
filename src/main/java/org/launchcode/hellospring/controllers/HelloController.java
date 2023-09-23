package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class HelloController {
    //handle request at path hello.
    //    @GetMapping("hello")
    //    @ResponseBody
    //    public String hello(){
    //      return "Hello Spring!";
    //    }
//lives in /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
      return "Goodbye Spring!";
    }

    //Handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
//    @PostMapping("hello")
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})

    //lives at /hello/hello
    @GetMapping
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, "+ name+"!";
    }
    //Handles request with path variable
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParameter(@PathVariable String name){
        return "Hello," +name+ "!";
    }

    //lives at /hello/form
    @GetMapping("/form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" +
                "<label for='name'>Name: </label><input type='text' name='name'>" +
                "<label for='language'>Language: </label>"+
                "<select name='language' id='language'>" +
                "<option value='zh'>Chinese - 中文</option>"+
                "<option value='es'>Spanish - español</option>"+
                "<option value='en'>English</option>"+
                "<option value='fr'>French</option>"+
                "</select>"+
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
    @PostMapping("/hello")
    @ResponseBody
    public String helloUser(@RequestParam String name, @RequestParam String language) {
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
        return "<html>" +
                "<body>" +
                "Greeting Message in "+lang+ ": "+message +" "+name+"!"+
                "</body>" +
                "</html>";
    }

}
