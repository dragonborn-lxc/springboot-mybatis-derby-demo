package com.endnesswaltz.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.endnesswaltz.demo.service.ConsumerService;

@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
	@Autowired
	private ConsumerService consumerService;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			consumerService.count();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
