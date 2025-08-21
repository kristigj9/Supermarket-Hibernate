package com.supermarket;

import com.supermarket.entity.*;
import com.supermarket.repositories.CustomerRepository;
import com.supermarket.repositories.OrderItemRepository;
import com.supermarket.repositories.OrderRepository;
import com.supermarket.repositories.ProductRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        //____________________Product____________________________

        Product p1 = new Product("CocaCola", 3.25, 4, "limonata");
        Product p2 = new Product("Fanta", 1.25, 20, "limonata");
        Product p3 = new Product("Pepsi", 2.25, 10, "limonata");
        Product p4 = new Product("Divella", 1.75, 60, "Makarona");
        Product p5 = new Product("Barrilla", 1.25, 70, "Makarona");
        Product p6 = new Product("MaxiBon", 5.25, 63, "Akullore");
        Product p7 = new Product("Maginum", 6.25, 72, "Akullore");


        ProductRepository productRepository = new ProductRepository();
        // productRepository.save();
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
        List<Product> products = productRepo.findAll();

        for (Product p : products) {
            System.out.println("ID: " + p.getId() + ", Emri: " + p.getName());
        }
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);
        productList.add(p7);
        for (Product product1:productList){
            productRepository.save(product1);
        }



        //________________________Customr________________________
        Customer c1 = new Customer("Kristi", "kristigj@gmail.com", "06435632", "Durres");
        Customer c2 = new Customer("Ana", "ana@gmail.com", "06454362", "Tirane");
        Customer c3 = new Customer("Dea", "dea@gmail.com", "06735732", "Tirane");


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

        List<Customer> customerList=new ArrayList<>();
        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);

        for (Customer customer1:customerList){
            customerRepository.save(customer1);
        }

        //___________________Orders________________________________
        LocalDate orederDate = LocalDate.parse("2024-05-05");// yyyy-MM-dd


        Order order1 = new Order(c1, OrderStatus.PENDING, orederDate, 2.0);
        Order order2 = new Order(c2, OrderStatus.SHIPPED, orederDate, 4.0);

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

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        for (Order o:orderList){
            orderRepository.saveOrder(o);
        }

        //________________________OrderItems______________________________________
        OrderItem orderItem1 = new OrderItem(order1, p1, 5);
        OrderItem orderItem2 = new OrderItem(order1, p2, 3);
        OrderItem orderItem3 = new OrderItem(order1, p6, 1);

        OrderItem orderItem4 = new OrderItem(order2, p4, 1);
        OrderItem orderItem5 = new OrderItem(order2, p5, 1);

        OrderItemRepository orderItemRepository = new OrderItemRepository();
        //orderItemRepository.saveOrderitemes(orderItem);
        //orderItemRepository.deleteOrderitemesID(5);
        // OrderItem orderItem1 = orderItemRepository.findOrederById(1);

        //if (orderItem1 != null) {System.out.println("OrderItem u gjet: ");
        //     orderItem1.setQuantity(7);
        //  orderItemRepository.updateOrderItems(orderItem1);
        //   System.out.println("OrderItems update me sukses");}
        //else {System.out.println("OrderItems nuk ekziston");}
        OrderItemRepository orderItemRepo = new OrderItemRepository();
        List<OrderItem> orderItems = orderItemRepo.findAll();

        for (OrderItem ot : orderItems) {
            System.out.println("ID: " + ot.getId() + ", PriceAtPurchase: " + ot.getPriceAtPurchase() + "Quantity: " + ot.getQuantity());
        }
        List<OrderItem> orderItemList= new ArrayList<>();
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);
        orderItemList.add(orderItem3);
        orderItemList.add(orderItem4);
        orderItemList.add(orderItem5);

        for (OrderItem ot1 : orderItemList) {
           orderItemRepository.saveOrderitemes(ot1);}

    }





}