package com.tiket.test.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers"
    , catalog = "test"
)
public class Customers implements Serializable {

  @Id
  @Column(name = "customerId", unique = true, nullable = false)
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long customerId;

  @Column(name = "company_name", length = 50)
  private String companyName;

  @Column(name = "first_name", length = 30)
  private String firstName;

  @Column(name = "last_name", length = 50)
  private String lastName;

  @Column(name = "billing_address", length = 255)
  private String billingAddress;

  @Column(name = "city", length = 50)
  private String city;

  @Column(name = "state_or_province", length = 20)
  private String stateOrProvince;

  @Column(name = "zip_code", length = 20)
  private String zipCode;

  @Column(name = "email", length = 75)
  private String email;

  @Column(name = "company_website", length = 200)
  private String companyWebsite;

  @Column(name = "phone_number", length = 30)
  private String phoneNumber;

  @Column(name = "fax_number", length = 30)
  private String faxNumber;

  @Column(name = "ship_address", length = 255)
  private String shipAddress;

  @Column(name = "ship_city", length = 50)
  private String shipCity;

  @Column(name = "ship_state_or_province", length = 50)
  private String shipStateOrProvince;

  @Column(name = "ship_zip_code", length = 20)
  private String shipZipCode;

  @Column(name = "ship_phone_number", length = 30)
  private String shipPhoneNumber;

  public Customers() {
  }

  public Customers(Long customerId){
    this.customerId = customerId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(String billingAddress) {
    this.billingAddress = billingAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStateOrProvince() {
    return stateOrProvince;
  }

  public void setStateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCompanyWebsite() {
    return companyWebsite;
  }

  public void setCompanyWebsite(String companyWebsite) {
    this.companyWebsite = companyWebsite;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getFaxNumber() {
    return faxNumber;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }

  public String getShipAddress() {
    return shipAddress;
  }

  public void setShipAddress(String shipAddress) {
    this.shipAddress = shipAddress;
  }

  public String getShipCity() {
    return shipCity;
  }

  public void setShipCity(String shipCity) {
    this.shipCity = shipCity;
  }

  public String getShipStateOrProvince() {
    return shipStateOrProvince;
  }

  public void setShipStateOrProvince(String shipStateOrProvince) {
    this.shipStateOrProvince = shipStateOrProvince;
  }

  public String getShipZipCode() {
    return shipZipCode;
  }

  public void setShipZipCode(String shipZipCode) {
    this.shipZipCode = shipZipCode;
  }

  public String getShipPhoneNumber() {
    return shipPhoneNumber;
  }

  public void setShipPhoneNumber(String shipPhoneNumber) {
    this.shipPhoneNumber = shipPhoneNumber;
  }
}
