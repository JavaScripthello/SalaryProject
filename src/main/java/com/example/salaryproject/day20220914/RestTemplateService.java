package com.example.salaryproject.day20220914;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: SalaryProject
 * @description:
 * @author: kangwei
 * @create: 2022-09-14 09:21
 **/
@Service
public class RestTemplateService {


    @Autowired
    private RestTemplate restTemplate;

    public String get(String url) {
        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }

    /**
     * post请求
     * exchange
     *
     * @return
     */
    public String post(String url, Integer age, String name) {
        //header参数
        HttpHeaders headers = new HttpHeaders();
        String token = "asdfaf2322";
        headers.add("authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //放入body中的json参数
        JSONObject obj = new JSONObject();
        obj.put("age", age);
        obj.put("name", name);

        //组装
        HttpEntity<JSONObject> request = new HttpEntity<>(obj, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        String body = responseEntity.getBody();
        return body;
    }

}
