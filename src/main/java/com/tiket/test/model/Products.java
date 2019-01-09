package com.tiket.test.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products"
    , catalog = "test"
)
public class Products implements Serializable {

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(name = "product_name", length = 250)
  private String productName;

  @Column(name = "unit_price", length = 20)
  private Double unitPrice;

  @Column(name = "in_stock", length = 1)
  private Integer inStock;

  public Products() {
  }

  public Products(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Integer getInStock() {
    return inStock;
  }

  public void setInStock(Integer inStock) {
    this.inStock = inStock;
  }
}


