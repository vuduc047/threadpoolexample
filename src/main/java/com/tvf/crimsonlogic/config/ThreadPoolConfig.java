package com.tvf.crimsonlogic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
//bắt buộc phải bật nếu k @Async k hoạt động
@EnableAsync
public class ThreadPoolConfig {
    //Ae dùng ThreadPoolExecutor hay ThreadPoolTaskExecutor đều được
    @Bean("executor")
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //core pool size số thread mặc định được khởi tạo
        executor.setCorePoolSize(20);
        //max pool size là số thread tối đa có thể được tạo ra
        executor.setMaxPoolSize(30);
        //capacity là hàng chờ , nếu số lượng thread mặc định khởi tạo k đủ khả năng để handel thì sẽ đầy vào hàng chờ
        // Nếu hàng chờ đầy sẽ tạo thêm 1 thread và cứ thế
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("Kẻ trộm ngô ");
        executor.setRejectedExecutionHandler(new RejectedTaskHandler());
        executor.initialize();
        return executor;
    }
}
