package com.bitian.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置类
 * @author admin
 */
@Configuration
@EnableScheduling
public class ThreadPoolConfig {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_SIZE = CPU_COUNT * 4;
    private static final int MAX_CORE_SIZE = CPU_COUNT * 8;

    @Bean("threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        threadPoolTaskExecutor.setCorePoolSize(CORE_SIZE);
        // 配置最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(MAX_CORE_SIZE);
        // 配置队列容量（这里设置成最大线程数的四倍）
        threadPoolTaskExecutor.setQueueCapacity(MAX_CORE_SIZE * 4);
        // 给线程池设置名称
        threadPoolTaskExecutor.setThreadNamePrefix("bt-thread-pool-thread");
        // 设置任务的拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return threadPoolTaskExecutor;
    }
}
