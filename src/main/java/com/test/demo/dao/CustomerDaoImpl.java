package com.test.demo.dao;

import com.test.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Customer> getAllCostumers() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> getAllQuery = currentSession.createQuery("from Customer", Customer.class);

        return getAllQuery.getResultList();
    }
}
