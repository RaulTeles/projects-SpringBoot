package com.teles.basicProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

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

    public Order(){}

    public Order(Long id, Instant moment, User clients) {
        this.id = id;
        this.moment = moment;
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

    public User getClients() {
        return clients;
    }

    public void setClients(User clients) {
        this.clients = clients;
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
