package com.liuganchen.indigo.api;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/test")
public class TestContainer {
    @GetMapping
    public String addAnswers() {
        return "测试成功";
    }

    public static void main(String[] args) {
        var list = new Integer[][]{{1, 2, 3}, {22, 33, 44}, {444, 555, 666}};
        var res1 = Arrays.stream(list).flatMap(Stream::of);
        var res2 = Arrays.stream(list).map(Arrays::toString);
        System.out.println(Arrays.toString(res1.toArray()));
        System.out.println(Arrays.toString(res2.toArray()));
        System.out.println(Arrays.toString(list));
    }
}
