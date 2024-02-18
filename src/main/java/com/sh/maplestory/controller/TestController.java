package com.sh.maplestory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Map<String, Object> test() {
        var map = new HashMap<String, Object>();

        map.put("date", LocalDateTime.now());
        map.put("message", "hello, world!");
        map.put("success", true);

        return map;
    }
}
