package com.supermarket.repositories;

import com.supermarket.entity.Customer;
import com.supermarket.entity.Order;
import com.supermarket.entity.Product;
import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerRepository {

    public void save(Customer c) {
        Transaction t = null;
        try (Session cusotmer = HibernateUtil.getSessionFactory().openSession()) {
            t = cusotmer.beginTransaction();
            cusotmer.save(c);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }

    }





    public void deleteCustomerById(int id) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Customer c = session.get(Customer.class, id);
            if (c != null) {
                session.delete(c);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();  // rollback ndodh ndërkohë që session është akoma hapur
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // mbyllet vetëm në fund
            }
        }
    }


    public Customer findCustomerById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, id); // merr customer sipas id
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void UpdateCustomer(Customer customer) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }




    public List<Customer> findAll() {
        List<Customer> customers = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customers = session.createQuery("FROM Customer", Customer.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

}



