package com.teles.basicProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teles.basicProject.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant moment;

    //Order for one Client a annotation serve para instruir que esse atributo é uma chave estrangeira
    //Significa que esta classe "Order" é muitos para um Classe "User"
    @ManyToOne
    //Nome da chave estrangeira que terá no outro banco de dados
    @JoinColumn(name = "client_id")
    private User clients;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();
    private Integer orderStatus;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payments payments;


    public Order(){}

    public Order(Long id, Instant moment, OrderStatus orderStatus,User clients) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClients() {
        return clients;
    }

    public void setClients(User clients) {
        this.clients = clients;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
