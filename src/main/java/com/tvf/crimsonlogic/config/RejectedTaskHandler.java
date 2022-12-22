package com.tvf.crimsonlogic.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class RejectedTaskHandler implements RejectedExecutionHandler
{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.warn("Bà cô đang chạy ra gank nên ae đi trốn");
        log.info("Bà cô đã vào nhà r nên ae ra trộm tiếp ");
        if (!executor.isShutdown()) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                log.error(String.valueOf(e));
            }
        }
    }
}