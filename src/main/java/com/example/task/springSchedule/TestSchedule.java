package com.example.task.springSchedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 只需要在springboot的启动类上加上@EnableScheduling
 * 一旦某个任务在执行过程中抛出异常，则整个定时器生命周期就结束，以后永远不会再执行定时器任务
 * @Author wuqingyan
 * Date 2019/9/29 15:44
 * Modify Log
 **/
@Component
public class TestSchedule {

    //每五秒执行一次
//    @Scheduled(cron = "*/5 * * * * ?")
//    public void testScheduleTask(){
//        System.out.println("spring-schedule定时任务执行中");
//    }
}
