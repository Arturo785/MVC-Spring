package com.test.demo.service;

import com.test.demo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCostumers();

    public void saveOrUpdate(Customer customer);

    Customer getClientById(int customerId);

    public void deleteCustomer(Customer customer);
}
