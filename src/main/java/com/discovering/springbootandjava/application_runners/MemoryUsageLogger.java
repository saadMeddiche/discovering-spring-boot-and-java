package com.discovering.springbootandjava.application_runners;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class MemoryUsageLogger implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(MemoryUsageLogger.class);

    @Override
    public void run(ApplicationArguments args) {
        Runtime runtime = Runtime.getRuntime();
        long memoryUsedBytes = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsedMB = memoryUsedBytes / (1024 * 1024);
        logger.info("Memory total: {} MB", runtime.totalMemory() / (1024 * 1024));
        logger.info("Memory free: {} MB", runtime.freeMemory() / (1024 * 1024));
        logger.info("Memory footprint at startup: {} MB", memoryUsedMB);
    }
}
