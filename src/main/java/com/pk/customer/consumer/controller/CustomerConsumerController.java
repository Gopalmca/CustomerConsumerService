package com.pk.customer.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.customer.consumer.model.CustomerConsumerAuditLog;
import com.pk.customer.consumer.service.CustomerConsumerServices;

@RestController
public class CustomerConsumerController {

	@Autowired
	private CustomerConsumerServices consumerCustomerService;

	@KafkaListener(groupId = "customer-2", topics = "customerproducer", containerFactory = "kafkaListenerContainerFactory")
	public String getMsgFromTopic(String data) {
		System.out.println(data);
		return null;
	}

	@GetMapping(value = "/getconsumercusts", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<CustomerConsumerAuditLog>> getConsumerCusts() {
		return new ResponseEntity<List<CustomerConsumerAuditLog>>(consumerCustomerService.getAllCustomerAuditLogs(),
				HttpStatus.OK);
	}

}
