package com.example.SpringDataJPA;

import com.example.SpringDataJPA.dto.CustomerDto;
import com.example.SpringDataJPA.entity.Customer;
import com.example.SpringDataJPA.repository.CustomerRepository;
import com.example.SpringDataJPA.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaApplication  implements CommandLineRunner {

	static Logger logger= LogManager.getLogger(SpringDataJpaApplication.class);
	static Scanner scanner=new Scanner(System.in);

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CustomerDto customer1= new CustomerDto(7022713754L, "Adam", 27, "M", "Chicago", 1);
		CustomerDto customer2= new CustomerDto(7022713744L, "Susan", 27, "F", "Alberta", 2);
		CustomerDto customer3= new CustomerDto(7022713722L, "Lucy", 27, "F", "MUMBAI", 3);


		logger.info(customerService.insertCustomer(customer1));
		logger.info(customerService.insertCustomer(customer2));
		logger.info(customerService.insertCustomer(customer3));


		logger.info("Enter the phone Number of the Customer which has to be deleted.");
		Long phoneNo1= scanner.nextLong();

		logger.info(customerService.remove(phoneNo1));

		logger.info("Let's update the current plan of a Customer");
		logger.info("Enter the phone Number of the Customer whose current plan has to be updated.");
		Long phoneNo2=scanner.nextLong();

		logger.info("Enter the name");
		String name=scanner.next();

		logger.info("Enter the age");
		Integer age=scanner.nextInt();

		logger.info("Enter the gender");
		String gender=scanner.next();

		logger.info("Enter the address");
		String address=scanner.next();

		logger.info("Enter the plan");
		Integer plan=scanner.nextInt();

		CustomerDto a=new CustomerDto();
		a.setPhoneNo(phoneNo2);
		a.setName(name);
		a.setAge(age);
		a.setGender(gender);
		a.setAddress(address);
		a.setPlanId(plan);

		logger.info(customerService.update(phoneNo2,a));

		ArrayList<Customer>aa= (ArrayList<Customer>) customerService.getall();
		for (Customer i:aa){
			logger.info(i);
		}

		logger.info("Enter the phone Number of the Customer which has to be fetch.");
		Long phoneN03= scanner.nextLong();
		logger.info(customerService.get1Customer(phoneN03));

		scanner.close();

		int k=(int) (customerRepository.count()/3);

		for (int i=0;i<=k;i++){
			Pageable page= PageRequest.of(i,3);

			Iterable<Customer>customer8=customerService.findAll(page);

			for (Customer z:customer8){
				logger.info(z);
			}
		}

		logger.info("soreted records");

		Iterable<Customer>customer9=customerService.findAll(Sort.by(Sort.Direction.ASC,"name"));

		for (Customer l:customer9){
			logger.info(l);
		}


	}
}
