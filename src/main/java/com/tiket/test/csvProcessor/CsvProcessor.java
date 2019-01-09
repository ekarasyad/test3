package com.tiket.test.csvProcessor;

import com.tiket.test.model.Customers;
import com.tiket.test.model.Employee;
import com.tiket.test.model.OrderDetails;
import com.tiket.test.model.Orders;
import com.tiket.test.model.Products;
import com.tiket.test.model.ShippingMethods;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CsvProcessor {

  public static List<ShippingMethods> processShippingMethodCsv() {
    String csvFile = "/Users/ekamulyana/Documents/csv/ShippingMethods.csv";
    String line = "";
    String cvsSplitBy = ";";
    List<ShippingMethods> shippingMethodList = new ArrayList<>();
    Integer count = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      while ((line = br.readLine()) != null) {
        if(count == 0){
          count ++;
          continue;
        }
        // use ; as separator
        String[] data = line.split(cvsSplitBy);
        ShippingMethods shippingMethods = new ShippingMethods();
        shippingMethods.setShippingMethod(data[1]);
        shippingMethodList.add(shippingMethods);
        count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return shippingMethodList;
  }

  public static List<Products> processProductCsv() throws ParseException{
    String csvFile = "/Users/ekamulyana/Documents/csv/Products.csv";
    String line = "";
    String cvsSplitBy = ";";
    List<Products> productsList = new ArrayList<>();
    Integer count = 0;

    NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      while ((line = br.readLine()) != null) {
        if(count == 0){
          count ++;
          continue;
        }
        // use ; as separator
        String[] data = line.split(cvsSplitBy);
        Products products = new Products();
        products.setProductName(data[1]);
        Number number = format.parse(data[2]);
        products.setUnitPrice(number.doubleValue());
        products.setInStock(Integer.parseInt(data[3]));
        productsList.add(products);
        count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return productsList;
  }

  public static List<Employee> processEmployeeCsv() {
    String csvFile = "/Users/ekamulyana/Documents/csv/Employees.csv";
    String line = "";
    String cvsSplitBy = ";";
    List<Employee> employeeList = new ArrayList<>();
    Integer count = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      while ((line = br.readLine()) != null) {
        if(count == 0){
          count ++;
          continue;
        }
        // use ; as separator
        String[] data = line.split(cvsSplitBy);
        Employee employee = new Employee();
        employee.setFirstName(data[1]);
        employee.setLastName(data[2]);
        employee.setTitle(data[3]);
        employee.setWorkPhone(data[4]);
        employeeList.add(employee);

        count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return employeeList;
  }

  public static List<Customers> processCustomerCsv() {
    String csvFile = "/Users/ekamulyana/Documents/csv/Customers.csv";
    String line = "";
    String cvsSplitBy = ";";
    List<Customers> customersList = new ArrayList<>();
    Integer count = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      while ((line = br.readLine()) != null) {
        if(count == 0){
          count ++;
          continue;
        }
        // use ; as separator
        String[] data = line.split(cvsSplitBy);
        Customers customers = new Customers();
        customers.setCompanyName(data[1]);
        customers.setFirstName(data[2]);
        customers.setLastName(data[3]);
        customers.setBillingAddress(data[4]);
        customers.setCity(data[5]);
        customers.setStateOrProvince(data[6]);
        customers.setZipCode(data[7]);
        customers.setEmail(data[8]);
        customers.setCompanyWebsite(data[9]);
        customers.setPhoneNumber(data[10]);
        customers.setFaxNumber(data[11]);
        customers.setShipAddress(data[12]);
        customers.setShipCity(data[13]);
        customers.setShipStateOrProvince(data[14]);
        customers.setShipZipCode(data[15]);
        customers.setShipPhoneNumber(data[16]);
        customersList.add(customers);
        count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return customersList;
  }

  public static List<Orders> processOrdersCsv() throws ParseException {
    DateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yy");
    String csvFile = "/Users/ekamulyana/Documents/csv/Orders.csv";
    String line = "";
    String cvsSplitBy = ";";
    List<Orders> ordersList = new ArrayList<>();
    Integer count = 0;

    NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);


    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      while ((line = br.readLine()) != null) {
        if(count == 0){
          count ++;
          continue;
        }
        // use ; as separator
        String[] data = line.split(cvsSplitBy);
        Orders orders = new Orders();
        orders.setCustomers(new Customers(Long.parseLong(data[1])));
        orders.setEmployee(new Employee(Long.parseLong(data[2])));
        orders.setOrderDate(simpleDateFormat.parse(data[3]));
        orders.setPurchaseOrderNumber(data[4]);
        orders.setShipDate(simpleDateFormat.parse(data[5]));
        orders.setShippingMethods(new ShippingMethods(Long.parseLong(data[6])));
        Number freightCharge = format.parse(data[7]);
        orders.setFreightCharge(freightCharge.doubleValue());
        Number taxes = format.parse(data[8]);
        orders.setTaxes(taxes.doubleValue());
        orders.setPaymentReceived(Integer.parseInt(data[9]));
        orders.setComment(data[10]);
        ordersList.add(orders);
        count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ordersList;
  }

  public static List<OrderDetails> processOrderDetailCsv() throws ParseException{
    String csvFile = "/Users/ekamulyana/Documents/csv/OrderDetails.csv";
    String line = "";
    String cvsSplitBy = ";";
    List<OrderDetails> orderDetailsList = new ArrayList<>();
    Integer count = 0;

    NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      while ((line = br.readLine()) != null) {
        if(count == 0){
          count ++;
          continue;
        }
        // use ; as separator
        String[] data = line.split(cvsSplitBy);
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrders(new Orders(Long.parseLong(data[1])));
        orderDetails.setProducts(new Products(Long.parseLong(data[2])));
        orderDetails.setQuantity(Integer.parseInt(data[3]));
        Number unitPrice = format.parse(data[4]);
        orderDetails.setUnitPrice(unitPrice.doubleValue());
        Number discount = format.parse(data[5]);
        orderDetails.setDiscount(discount.doubleValue());
        orderDetailsList.add(orderDetails);
        count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return orderDetailsList;
  }
}
