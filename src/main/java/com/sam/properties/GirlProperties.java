package com.sam.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by SamZhao on 2017/5/4.
 */
@ConfigurationProperties(prefix = "girl")
@Component
public class GirlProperties {

    private String cupSize;

    private int age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
