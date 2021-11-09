package com.test.demo.service;

import com.test.demo.dao.CustomerDao;
import com.test.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class CustomerServiceImpl implements CustomerService {

    // the service is the one that will manage the transactions


    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public List<Customer> getAllCostumers() {
        return customerDao.getAllCostumers();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Customer customer) {
        customerDao.saveOrUpdate(customer);
    }

    @Override
    @Transactional
    public Customer getClientById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        customerDao.deleteCustomer(customer);
    }
}
