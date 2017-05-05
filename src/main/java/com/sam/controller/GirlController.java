package com.sam.controller;

import com.sam.domain.Girl;
import com.sam.domain.Result;
import com.sam.repository.GirlRepository;
import com.sam.service.GirlService;
import com.sam.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by SamZhao on 2017/5/4.
 */
@RestController
@RequestMapping(value = "/girl")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlServive;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girlRepository.save(girl);
        return ResultUtil.success(girl);
    }

    //查询
    @GetMapping(value = "/girl/{id}")
    public Girl girlGet(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    //更新
    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("age") Integer age, @RequestParam("cupSize") String cupSize){
        Girl girl = girlRepository.findOne(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    //年龄查询
    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> girlAgeGet(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girl/two")
    public void getTwo(){
        girlServive.insertTwo();
    }

    @GetMapping(value = "/girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlServive.getAge(id);
    }
}
