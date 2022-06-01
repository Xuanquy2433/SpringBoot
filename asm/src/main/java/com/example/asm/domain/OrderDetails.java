package com.example.asm.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "orderDetail")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50, nullable = false)
    private int Id;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Products products;

    // @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @EqualsAndHashCode.Exclude
    // @ToString.Exclude
    // @JoinTable(name = "Detail_Product", joinColumns = @JoinColumn(name =
    // "orderDetail_id"), inverseJoinColumns = @JoinColumn(name = "product_Id"))
    // private Collection<Products> products;

    @Column(length = 200, nullable = false)
    private float price;
    @Column(length = 200, nullable = false)
    private int quantity;
}
