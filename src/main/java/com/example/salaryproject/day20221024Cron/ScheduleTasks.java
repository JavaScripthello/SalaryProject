package com.example.salaryproject.day20221024Cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: SalaryProject
 * @description: 定时任务执行类
 * @author: kangwei
 * @create: 2022-10-24 09:12
 **/
@PropertySource(value = {"classpath:task-config.yml"})
@Component
@Slf4j
public class ScheduleTasks implements SchedulingConfigurer {
    //定时任务表达式
    @Value("${printTime.cron}")
    private String cron;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> {

            log.info("定时任务执行" + Thread.currentThread().getName());
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger cronTrigger = new CronTrigger(cron);
                Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);
                return nextExecutionTime;
            }
        });
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
