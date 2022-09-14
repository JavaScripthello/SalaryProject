package com.example.salaryproject.day20220914;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: SalaryProject
 * @description: restTemplate控制
 * @author: kangwei
 * @create: 2022-09-14 09:39
 **/
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping
    public String get(){
        return restTemplateService.get("https://www.baidu.com");
    }
}
