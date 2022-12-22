package com.tvf.crimsonlogic.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class ThreadService {

    @Async("executor")
    public Future<String> methodWithSomeReturnType(int i) {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " bếch được bắp ngô " + i);
            return new AsyncResult<String>("hello world !!!!" + i);
        } catch (InterruptedException e) {
        }
        return null;
    }
}
