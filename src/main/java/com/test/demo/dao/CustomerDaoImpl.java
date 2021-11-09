package com.test.demo.dao;

import com.test.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getAllCostumers() {
        Session currentSession = sessionFactory.getCurrentSession();

        // the query sorted

        Query<Customer> getAllQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        return getAllQuery.getResultList();
    }

    @Override
    public void saveOrUpdate(Customer costumer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(costumer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Customer.class, customerId);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.delete(customer);
    }
}
