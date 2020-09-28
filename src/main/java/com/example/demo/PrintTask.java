package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/12/16:24
 * @Description:
 */
@Component
public class PrintTask {
    /**
     * 定时任务，每一秒执行一次
     */
    @Scheduled(fixedRate = 1000)
    public void printT(){
        System.out.println("打印了------"+new Date(System.currentTimeMillis()));
    }
}
