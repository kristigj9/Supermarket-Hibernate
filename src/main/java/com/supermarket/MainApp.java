package com.supermarket;

import com.supermarket.entity.*;
import com.supermarket.repositories.CustomerRepository;
import com.supermarket.repositories.OrderItemRepository;
import com.supermarket.repositories.OrderRepository;
import com.supermarket.repositories.ProductRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        //____________________Product____________________________
        Product p1 = new Product("Makarona", 3.25, 4, "ushqime");
        ProductRepository productRepository = new ProductRepository();
        // productRepository.save(p1);
        //productRepository.deleteProduct(p1);//Nuk ekzekutohet kur p1 eshte inseruar 2 here
        // productRepository.deleteById(6);

        Product product = productRepository.findOrederById(1);
        //if(product!=null){
        //System.out.println("Produkti u gjet");
        //  product.setName("Coca Cola");
        //  productRepository.updateProdukt(product);
        // System.out.println("Produkti u be update");}
        // else {System.out.println("Produkti nuk u gjet");}

        ProductRepository productRepo = new ProductRepository();
        List<Product> procucts = productRepo.findAll();

        for (Product p : procucts) {
            System.out.println("ID: " + p.getId() + ", Emri: " + p.getName());
        }

        //________________________Customr________________________
        Customer c1 = new Customer("Kristi", "kristigj@gmail.com", "06435632", "Rruga Marin Barleti");
        CustomerRepository customerRepository = new CustomerRepository();
        //customerRepository.save(c1);
        //customerRepository.deleteCustomerById(3);
        // customerRepository.updateCustomerID(4);
        //Customer c2 =customerRepository.findCustomerById(5);
        // if (c2 != null) {System.out.println("Order u gjet: ");
        //    c2.setName("Ana");
        // customerRepository.UpdateCustomer(c2);
        //     System.out.println("Customer update me sukses");}
        // else {System.out.println("Customer  nuk ekziston");}


        CustomerRepository customerRepo = new CustomerRepository();
        List<Customer> customers = customerRepo.findAll();

        for (Customer c : customers) {
            System.out.println("ID: " + c.getId() + ", Emri: " + c.getName());
        }


        //___________________Orders________________________________
        LocalDate orederDate = LocalDate.parse("2024-05-05");  // yyyy-MM-dd

        Order order = new Order(c1, OrderStatus.PENDING, orederDate, 4.0);
        OrderRepository orderRepository = new OrderRepository();
        //orderRepository.saveOrder(order);
        //orderRepository.deleteOrder(order);
        // orderRepository.deleteOrderByID(9);
        //orderRepository.findOrederById(10);
        //if (order != null) {System.out.println("Order u gjet: ");} else {System.out.println("Order  nuk ekziston");}
        //orderRepository.saveOrUpdateOrder(order);
        //Order order1 = orderRepository.findOrederById(10);
        //order1.setStatus(OrderStatus.SHIPPED);
        // orderRepository.UpdateOrder(order1);

        OrderRepository orderRepo = new OrderRepository();
        List<Order> orders = orderRepo.findAll();

        for (Order o : orders) {
            System.out.println("ID: " + o.getId() + ", Status: " + o.getStatus());
        }


        //________________________OrderItems______________________________________
        OrderItem orderItem = new OrderItem(order, p1, 5);
        OrderItemRepository orderItemRepository = new OrderItemRepository();
        //orderItemRepository.saveOrderitemes(orderItem);
        //orderItemRepository.deleteOrderitemesID(5);
        // OrderItem orderItem1 = orderItemRepository.findOrederById(1);

        //if (orderItem1 != null) {System.out.println("OrderItem u gjet: ");
        //     orderItem1.setQuantity(7);
        //  orderItemRepository.updateOrderItems(orderItem1);
        //   System.out.println("OrderItems update me sukses");}
        //else {System.out.println("OrderItems nuk ekziston");}
        OrderItemRepository  orderItemRepo = new OrderItemRepository();
        List<OrderItem> orderitems= orderItemRepo.findAll();

        for (OrderItem ot : orderitems) {
            System.out.println("ID: " + ot.getId() + ", PriceAtPurchase: " + ot.getPriceAtPurchase()+ "Quantity: "+ot.getQuantity());
        }

    }


}