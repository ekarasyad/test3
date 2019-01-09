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
@Table(name = "employee"
    , catalog = "test"
)
public class Employee implements Serializable {

  @Id
  @Column(name = "employeeId", unique = true, nullable = false)
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long employeeId;

  @Column(name = "first_name", length = 50)
  private String firstName;

  @Column(name = "last_name", length = 50)
  private String lastName;

  @Column(name = "title", length = 50)
  private String title;

  @Column(name = "work_phone", length = 30)
  private String workPhone;

  public Employee() {
  }

  public Employee(Long employeeId){
    this.employeeId = employeeId;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }
}
