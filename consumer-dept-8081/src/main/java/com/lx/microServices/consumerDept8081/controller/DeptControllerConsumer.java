package com.lx.microServices.consumerDept8081.controller;


import com.lx.microServices.api.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lx
 * @date 2020/12/13
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptControllerConsumer {

    private final static String REST_URL_PREFIX_ONCE = "http://localhost:8001";
    private final static String REST_URL_PREFIX = "http://PROVIDER-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public Boolean add(@RequestBody Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @GetMapping("/list")
    public List<?> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery",Object.class);
    }
}
