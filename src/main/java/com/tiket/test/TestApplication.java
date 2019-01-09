package com.tiket.test;

import com.tiket.test.csvProcessor.CsvProcessor;
import com.tiket.test.model.Customers;
import com.tiket.test.model.OrderDetails;
import com.tiket.test.model.Products;
import com.tiket.test.model.ShippingMethods;
import com.tiket.test.repository.CustomerRepository;
import com.tiket.test.repository.EmployeeRepository;
import com.tiket.test.repository.OrderDetailRepository;
import com.tiket.test.repository.OrdersRepository;
import com.tiket.test.repository.ProductRepository;
import com.tiket.test.repository.ShippingMethodRepository;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Mono;

@Configuration
@SpringBootApplication(scanBasePackages = "com.tiket")
public class TestApplication {

  @Autowired
  private ShippingMethodRepository shippingMethodRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private OrdersRepository ordersRepository;

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  public static void main(String[] args) {
    SpringApplication.run(TestApplication.class, args);

  }

  @EventListener(ApplicationReadyEvent.class)
  public void doSomethingAfterStartup() throws ParseException {
    /*import shipping methods*/
    shippingMethodRepository.saveAll(CsvProcessor.processShippingMethodCsv());

    /*import products*/
    productRepository.saveAll(CsvProcessor.processProductCsv());

    /*import employee*/
    employeeRepository.saveAll(CsvProcessor.processEmployeeCsv());

    /*import customer*/
    customerRepository.saveAll(CsvProcessor.processCustomerCsv());

    /*import orders*/
    ordersRepository.saveAll(CsvProcessor.processOrdersCsv());

    /*import order detail*/
    orderDetailRepository.saveAll(CsvProcessor.processOrderDetailCsv());

    System.out.println("Success importing csv !");
  }
}

