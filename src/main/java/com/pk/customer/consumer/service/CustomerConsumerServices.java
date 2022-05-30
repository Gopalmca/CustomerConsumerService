package com.pk.customer.consumer.service;

import java.util.List;

import com.pk.customer.consumer.model.CustomerConsumerAuditLog;
import com.pk.customer.consumer.model.Customer;

public interface CustomerConsumerServices {

	public void saveConsumerCustAudit(Customer customer);

	public List<CustomerConsumerAuditLog> getAllCustomerAuditLogs();

}
