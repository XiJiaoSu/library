package com.library.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 *
 */
@Component
public class WebTask {

	
	// 每五秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void TaskJob() {
        System.out.println("test second annotation style ...");
    }
}
