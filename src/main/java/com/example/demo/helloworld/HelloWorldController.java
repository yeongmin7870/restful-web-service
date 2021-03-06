package com.example.demo.helloworld;

import com.example.demo.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;



    //Get
    // /helo-world(endpoint)
    // @RequestMapping(method=RequestMethod.Get, path="/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // bean 형태로 전송사 spring boot 는 단순 text형식이 아닌 json형태로 보내준다.

    @GetMapping(path = "/hello-world-Bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @PostMapping(path = "/hello-world-Bean/{hi}")
    public String createhello(@RequestBody  @PathVariable String hi){
        HelloWorldBean message = new HelloWorldBean(hi);
        return message.getMessge();
    }

    @GetMapping(path = "/hello-world-Bean/path-variable/{name}")
    public  HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world,%s",name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("greeting.message",null,locale);
    }
}
