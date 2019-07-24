package com.lim.timing.task;

import com.lim.timing.model.ModbusConfigDORepository;
import com.lim.timing.service.ModBusPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;


/**
 * @BelongsProject: timing
 * @BelongsPackage: com.lim.timing.task
 * @Author: lim
 * @CreateTime: 2019-07-16 11:28
 * @Description: TODO
 */

@Component
@Configuration
@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Autowired
    private ModbusConfigDORepository modbusConfigDORepository;

    @Autowired
    private ModBusPollService modBusPollService;
    // 执行定时任务
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        // 设定一个长度100的定时任务线程池,  多线程定时任务
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(100));

        scheduledTaskRegistrar.addTriggerTask(
                // 1.添加任务内容(Runnable)
                () -> {
                    System.out.println("定时任务开始:" + LocalDateTime.now().toLocalTime() + "\r\n线程:" +Thread.currentThread().getName());
                    System.out.println("--------------------------------------------");
                    modBusPollService.goData();
                    System.out.println("--------------------------------------------");
                },
                // 2.设置执行周期(Trigger)
                triggerContext -> {
                    // 2.1 从数据库获取执行周期
                    String cron = modbusConfigDORepository.findById(1).get().getMdTomeout();
                    // 2.2 合法性效验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
//                    System.out.println(cron);
                    // 2.3返回执行周期
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
