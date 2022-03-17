package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    //Get
    // /helo-world(endpoint)
    // @RequestMapping(method=RequestMethod.Get, path="/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // bean 형태로 전송사 spring boot 는 단순 text형식이 아닌 json형태로 보내준다.

    @GetMapping(path = "/hello-world-Bean")
    public  HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @PostMapping(path = "/hello-world-Bean/{hi}")
    public String createhello(@RequestBody  @PathVariable String hi){
        HelloWorldBean message = new HelloWorldBean(hi);
        return message.getMessge();
    }
}
