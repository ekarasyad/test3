package com.tiket.test.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details"
    , catalog = "test"
)
public class OrderDetails implements Serializable {

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  private Orders orders;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", nullable = false)
  private Products products;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "unit_price")
  private Double unitPrice;

  @Column(name = "discount")
  private Double discount;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Orders getOrders() {
    return orders;
  }

  public void setOrders(Orders orders) {
    this.orders = orders;
  }

  public Products getProducts() {
    return products;
  }

  public void setProducts(Products products) {
    this.products = products;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }
}
