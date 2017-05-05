package com.sam.service;

import com.sam.domain.Girl;
import com.sam.enums.ResultEnum;
import com.sam.exception.GirlException;
import com.sam.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by SamZhao on 2017/5/4.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl a = new Girl();
        a.setCupSize("A");
        a.setAge(18);
        girlRepository.save(a);
        Girl b = new Girl();
        b.setCupSize("BBB");
        b.setAge(19);
        girlRepository.save(b);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10 ){
            //返回  "你还在上小学吧"
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回  "你还在上初中吧"
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //...
    }

    /**
     * 通过ID查询一个女生信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
