package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.library.service.OrderService;

/**
 * 定时器
 *
 */
@Component
public class WebTask {

	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
	// 每天6点到20点内容,每5分钟执行一次
    @Scheduled(cron = "0 0/5 6-20 * * ?")
    public void TaskJob1() {
        System.out.println("test second annotation style ...");
        try {
			orderService.checkOrders();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * 每天凌晨00:01执行
     */
    @Scheduled(cron = "0 1 0 * * ?")
    public void TaskJob2() {
        System.out.println("test second annotation style ...");
    }
}
