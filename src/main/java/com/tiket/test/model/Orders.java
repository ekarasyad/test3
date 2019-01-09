package com.tiket.test.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders"
    , catalog = "test"
)
public class Orders implements Serializable {

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customers customers;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id", nullable = false)
  private Employee employee;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "order_date", length = 19)

  private Date orderDate;
  @Column(name = "purchase_order_number", length = 250)
  private String purchaseOrderNumber;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ship_date", length = 19)
  private Date shipDate;

  private ShippingMethods shippingMethods;

  @Column(name = "freight_charge")
  private Double freightCharge;

  @Column(name = "taxes")
  private Double taxes;

  @Column(name = "payment_received", length = 1)
  private Integer paymentReceived;

  @Column(name = "product_name", length = 150)
  private String comment;

  public Orders() {
  }

  public Orders(Long id){
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Customers getCustomers() {
    return customers;
  }

  public void setCustomers(Customers customers) {
    this.customers = customers;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public String getPurchaseOrderNumber() {
    return purchaseOrderNumber;
  }

  public void setPurchaseOrderNumber(String purchaseOrderNumber) {
    this.purchaseOrderNumber = purchaseOrderNumber;
  }

  public Date getShipDate() {
    return shipDate;
  }

  public void setShipDate(Date shipDate) {
    this.shipDate = shipDate;
  }

  public ShippingMethods getShippingMethods() {
    return shippingMethods;
  }

  public void setShippingMethods(ShippingMethods shippingMethods) {
    this.shippingMethods = shippingMethods;
  }

  public Double getFreightCharge() {
    return freightCharge;
  }

  public void setFreightCharge(Double freightCharge) {
    this.freightCharge = freightCharge;
  }

  public Double getTaxes() {
    return taxes;
  }

  public void setTaxes(Double taxes) {
    this.taxes = taxes;
  }

  public Integer getPaymentReceived() {
    return paymentReceived;
  }

  public void setPaymentReceived(Integer paymentReceived) {
    this.paymentReceived = paymentReceived;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
