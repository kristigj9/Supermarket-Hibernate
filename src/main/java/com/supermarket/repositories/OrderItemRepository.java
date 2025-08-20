package com.supermarket.repositories;

import com.supermarket.entity.OrderItem;
import com.supermarket.entity.Product;
import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderItemRepository {

    public void saveOrderitemes(OrderItem Ot){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(Ot);
            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();}
    }


    public void deleteOrderitemesID(int id){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            OrderItem orderItem = s.get(OrderItem.class,id);
            if (orderItem!= null) {
                s.delete(orderItem); // ose session.delete(p);
            }

            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();}
    }


    public OrderItem findOrederById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(OrderItem.class, id); // merr order sipas id
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updateOrderItems(OrderItem orderItem) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(orderItem);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }



    public List<OrderItem> findAll() {
        List<OrderItem> orderItems = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderItems = session.createQuery("FROM OrderItem", OrderItem.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderItems;
    }


}
