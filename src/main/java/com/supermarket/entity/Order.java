package com.supermarket.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private double total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)

    private List<OrderItem> items = new ArrayList<>();


    public Order() {
    }

    public Order(Customer customer, OrderStatus status,LocalDate orderDate, double total) {
        this.customer = customer;
        this.status = status;
        this.orderDate = orderDate;
        this.total =total;

    }

    // metoda për llogaritje të totalit
    public void calculateTotal() {
        this.total = items.stream().mapToDouble(i -> i.getPriceAtPurchase() * i.getQuantity()).sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;

    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", total=" + total +
                ", items=" + items +
                '}';
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
