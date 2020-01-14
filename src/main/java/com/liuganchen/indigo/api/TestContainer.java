package com.liuganchen.indigo.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestContainer {
    @GetMapping
    public String addAnswers() {
        return "测试成功";
    }
}
