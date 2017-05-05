package com.sam.controller;

import com.sam.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by SamZhao on 2017/5/4.
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello/{id}", "/hi/{id}"} , method = RequestMethod.GET)
    public String hello(@PathVariable String id){
        return "Hello Spring Boot! "+girlProperties.toString();
//        return "index";
    }

    @GetMapping(value = {"/say"})
//    @RequestMapping(value = {"/say"} , method = RequestMethod.GET)
    public String say(@RequestParam( value = "id", required = false ,defaultValue = "0") String id){
        return "id:"+id;
    }

}
