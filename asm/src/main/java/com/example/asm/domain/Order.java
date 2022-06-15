package com.example.asm.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String customerName;
    @Column(length = 15, nullable = false)
    String phone;
    @Column(length = 200, nullable = false)
    String note;
    double total;
    @ManyToOne
    @JoinColumn(name = "username")
    private Account account;
    int status;
    @OneToMany(mappedBy = "order")
    Set<OrderDetail> orderDetails;



    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(length = 50, nullable = false)
    // private int id;

    // @ManyToOne
    // @JoinColumn(name = "username")
    // private Account accounts;

    // @Column(length = 200, nullable = false)
    // private String createDate;
    // @Column(length = 200, nullable = false)
    // private String address;
}
