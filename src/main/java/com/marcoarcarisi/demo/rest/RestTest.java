package com.marcoarcarisi.demo.rest;

import com.marcoarcarisi.demo.service.StandardStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pippo")
public class RestTest {

    @Autowired
    private StandardStringService service;

    @GetMapping("/pino")
    public List<String> sayHello(){
        return service.getListaString();
    }
}
