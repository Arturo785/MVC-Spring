package com.test.demo.dao;

import com.test.demo.entity.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCostumers();

    void saveOrUpdate(Customer costumer);

    Customer getCustomerById(int customerId);

    void deleteCustomer(Customer customer);
}
