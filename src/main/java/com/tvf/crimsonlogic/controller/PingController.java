package com.tvf.crimsonlogic.controller;

import com.tvf.crimsonlogic.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ping")
public class PingController {

    @Autowired
    private ThreadService threadService;

    @GetMapping()
    public void steal() {
        for (int i =0; i < 100; i ++) {
            threadService.methodWithSomeReturnType(i);
        }
    }
}
