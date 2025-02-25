package com.sd.tliaswebmanagement;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;
import java.util.Arrays;

public class LogTest {

    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog(){
//        System.out.println(LocalDateTime.now() + " : 开始计算...");
        log.debug("开始计算");
        int sum;
        int[] nums = {1, 5, 3, 2, 1, 4, 5, 4, 6, 7, 4, 34, 2, 23};
        sum = Arrays.stream(nums).sum();
        
//        System.out.println("计算结果为: "+sum);
//        System.out.println(LocalDateTime.now() + "结束计算...");
        log.debug("结束计算");
        log.debug("计算结果为: {}",sum);

    }

}
