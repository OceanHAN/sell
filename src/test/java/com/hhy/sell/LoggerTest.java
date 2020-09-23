package com.hhy.sell;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    @Test
    public void test1(){
        String name = "abc";
        String password = "123456";
        log.info("debugger ------------");
        log.info("info------------");
        log.info("name:"+name+"  password:"+password);
        log.info("name:{},password:{}",name,password);
        log.error("error ---------");
    }
}
