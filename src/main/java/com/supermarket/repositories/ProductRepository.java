package com.supermarket.repositories;

import com.supermarket.entity.Order;
import com.supermarket.entity.OrderItem;
import com.supermarket.entity.Product;
import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductRepository {

    public void save(Product p) {
        Transaction t = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            s.save(p);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }

    }
        public void deleteProduct(Product p) {
            Transaction transaction= null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.delete(p);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                e.printStackTrace();
            }
        }


    public void deleteById(int id) {
        Transaction ti = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ti = session.beginTransaction();

            Product p = session.get(Product.class, id); // merr nga DB
            if (p != null) {
                session.delete(p); // ose session.delete(p);
            }

            ti.commit();
        } catch (Exception e) {
            if (ti != null) ti.rollback();
            e.printStackTrace();
        }
    }


    public Product findOrederById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, id); // merr order sipas id
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updateProdukt(Product product) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}

