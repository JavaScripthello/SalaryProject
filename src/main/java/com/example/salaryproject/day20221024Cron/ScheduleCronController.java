package com.example.salaryproject.day20221024Cron;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: SalaryProject
 * @description: 定时任务
 * @author: kangwei
 * @create: 2022-10-24 09:09
 **/
@RestController
@Slf4j
@RequestMapping("/cron")
public class ScheduleCronController {

    @Resource
    private final ScheduleTasks scheduleTasks;

    public ScheduleCronController(ScheduleTasks scheduleTasks){
        this.scheduleTasks = scheduleTasks;
    }

    /**
     * 更改定时任务表达式
     *
     * @param requestParams
     * @return
     */
    @PostMapping("/updateCron")
    public String updateCron(String requestParams) {
        //
        scheduleTasks.setCron(requestParams);
        JSONObject data = new JSONObject();
        data.put("flag", "ok");
        return data.toJSONString();
    }
}
