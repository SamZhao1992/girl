package com.sam;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SamZhao on 2017/5/4.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄查询
    public List<Girl> findByAge(Integer age);
}
