package com.lee.blog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * Created by Lee Yian on 2023/4/8 20:26
 */
public class MainTest {
    Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void test(){
        logger.error("FDSFDS");
    }
}
