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
        shippingMethods.setShippingMethod(data[1].replace("\n",""));
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
        products.setProductName(data[1].replace("\n",""));
        Number number = format.parse(data[2].replace("\n",""));
        products.setUnitPrice(number.doubleValue());
        products.setInStock(Integer.parseInt(data[3].replace("\n","")));
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
        employee.setFirstName(data[1].replace("\n",""));
        employee.setLastName(data[2].replace("\n",""));
        employee.setTitle(data[3].replace("\n",""));
        employee.setWorkPhone(data[4].replace("\n",""));
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
        customers.setCompanyName(data[1].replace("\n",""));
        customers.setFirstName(data[2].replace("\n",""));
        customers.setLastName(data[3].replace("\n",""));
        customers.setBillingAddress(data[4].replace("\n",""));
        customers.setCity(data[5].replace("\n",""));
        customers.setStateOrProvince(data[6].replace("\n",""));
        customers.setZipCode(data[7].replace("\n",""));
        customers.setEmail(data[8].replace("\n",""));
        customers.setCompanyWebsite(data[9].replace("\n",""));
        customers.setPhoneNumber(data[10].replace("\n",""));
        customers.setFaxNumber(data[11].replace("\n",""));
        customers.setShipAddress(data[12].replace("\n",""));
        customers.setShipCity(data[13].replace("\n",""));
        customers.setShipStateOrProvince(data[14].replace("\n",""));
        customers.setShipZipCode(data[15].replace("\n",""));
        customers.setShipPhoneNumber(data[16].replace("\n",""));
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
        orders.setCustomers(new Customers(Long.parseLong(data[1].replace("\n",""))));
        orders.setEmployee(new Employee(Long.parseLong(data[2].replace("\n",""))));
        orders.setOrderDate(simpleDateFormat.parse(data[3].replace("\n","")));
        orders.setPurchaseOrderNumber(data[4].replace("\n",""));
        orders.setShipDate(simpleDateFormat.parse(data[5].replace("\n","")));
        orders.setShippingMethods(new ShippingMethods(Long.parseLong(data[6].replace("\n",""))));
        Number freightCharge = format.parse(data[7].replace("\n",""));
        orders.setFreightCharge(freightCharge.doubleValue());
        Number taxes = format.parse(data[8].replace("\n",""));
        orders.setTaxes(taxes.doubleValue());
        orders.setPaymentReceived(Integer.parseInt(data[9].replace("\n","")));
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
        orderDetails.setOrders(new Orders(Long.parseLong(data[1].replace("\n",""))));
        orderDetails.setProducts(new Products(Long.parseLong(data[2].replace("\n",""))));
        orderDetails.setQuantity(Integer.parseInt(data[3].replace("\n","")));
        Number unitPrice = format.parse(data[4].replace("\n",""));
        orderDetails.setUnitPrice(unitPrice.doubleValue());
        Number discount = format.parse(data[5].replace("\n",""));
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
