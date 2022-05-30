package com.pk.customer.consumer.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.customer.consumer.model.Customer;
import com.pk.customer.consumer.model.CustomerConsumerAuditLog;
import com.pk.customer.consumer.repository.CustomerConsumerServiceRepository;

@Service("consumerCustomerService")
public class CustomerConsumerServiceImpl implements CustomerConsumerServices {

	private static final Logger log = LoggerFactory.getLogger(CustomerConsumerServiceImpl.class);

	@Autowired
	private CustomerConsumerServiceRepository consumerCustRepository;

	@KafkaListener(groupId = "customer-2", topics = "customerproducer", containerFactory = "userKafkaListenerContainerFactory")
	public void getJsonMsgFromTopic(Customer customer) {
		log.info("Consumer Data" + customer);
		saveConsumerCustAudit(customer);
	}

	@Override
	public List<CustomerConsumerAuditLog> getAllCustomerAuditLogs() {
		log.info("getAllCustomerAuditLogs method calling");
		return consumerCustRepository.findAll();
	}

	@Override
	public void saveConsumerCustAudit(Customer customer) {

		System.out.println(customer.toString());
		CustomerConsumerAuditLog auditLog = new CustomerConsumerAuditLog();
		String custJson = null;
		try {
			custJson = new ObjectMapper().writeValueAsString(customer);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (customer.getCustomerId() != null) {
			auditLog.setCustomerId(customer.getCustomerId());
		}
		auditLog.setCustomerPayload(custJson);
		auditLog.setCreateDate(new Date());
		auditLog.setCreatedBy(customer.getFirstName());
		auditLog.setModifiedBy(customer.getFirstName());

		consumerCustRepository.save(auditLog);
	}
}
