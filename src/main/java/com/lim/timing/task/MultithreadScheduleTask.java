package com.lim.timing.task;

import com.lim.timing.service.ModBusPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @BelongsProject: timing
 * @BelongsPackage: com.lim.timing.task
 * @Author: lim
 * @CreateTime: 2019-07-16 13:05
 * @Description: TODO
 */

@Component
@EnableScheduling
@EnableAsync
public class MultithreadScheduleTask {

    @Autowired
    private ModBusPollService modBusPollService;

    @Async
    @Scheduled(fixedDelay = 1000)
    public void first() {
//        System.out.println("定时任务开始:" + LocalDateTime.now().toLocalTime() + "\r\n线程:" +Thread.currentThread().getName());
//        System.out.println("--------------------------------------------");
//        modBusPollService.goData();
//        System.out.println("--------------------------------------------");
    }


}