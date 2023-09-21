package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //handle request at path hello.
    //    @GetMapping("hello")
    //    @ResponseBody
    //    public String hello(){
    //      return "Hello Spring!";
    //    }
//lives in /hello/goodbye
    @GetMapping("goodbye")

    public String goodbye(){
      return "Goodbye Spring!";
    }

    //Handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
//    @PostMapping("hello")
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})

    //lives at /hello/hello
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, "+ name+"!";
    }
    //Handles request with path variable
    @GetMapping("{name}")

    public String helloWithPathParameter(@PathVariable String name){
        return "Hello," +name+ "!";
    }

    //lives at /hello/form
    @GetMapping("form")

    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
