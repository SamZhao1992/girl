package com.sam;

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
}
