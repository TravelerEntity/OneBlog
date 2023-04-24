package com.lee.blog;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Created by Lee Yian on 2023/4/8 20:26
 */
public class MainTest {
    Logger logger = LogManager.getLogger(this.getClass());



    @Test
    public void test(){
        for (int i = 0; i < 30; i++) {
            int u3 = (new Random().nextInt(6))+1;
            System.out.println("/static/img/default_avatar_"+u3+".png");
        }
    }

    @Test
    public void methodCiteTest(){
        String a = "hello world";
    }
}
