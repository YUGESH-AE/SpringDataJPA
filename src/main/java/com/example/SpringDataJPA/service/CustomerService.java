package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.dto.CustomerDto;
import com.example.SpringDataJPA.entity.Customer;
import com.example.SpringDataJPA.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String insertCustomer(CustomerDto customer){
        customerRepository.saveAndFlush(CustomerDto.customerEntity(customer));
        return "Records inserted successfully";
    }

    public String remove(Long phoneNo){
        customerRepository.deleteById(phoneNo);
        return "The customer whose "+phoneNo+" deleted successfully";
    }

    public String update(Long phoneNo,CustomerDto customer){
        Optional<Customer>optionalCustomer=customerRepository.findById(phoneNo);
        Customer cust=optionalCustomer.get();
        cust.setName(customer.getName());
        cust.setAge(customer.getAge());
        cust.setAddress(customer.getAddress());
        cust.setGender(customer.getGender());
        cust.setPlanId(customer.getPlanId());
        customerRepository.save(cust);

        return "The customer whose "+phoneNo+" updated successfully";
    }

    public List<Customer> getall(){
        return customerRepository.findAll();
    }

    public CustomerDto get1Customer(Long phoneNo){
        Optional<Customer>optionalCustomer=customerRepository.findById(phoneNo);
        Customer cust=optionalCustomer.get();
        CustomerDto customerDto=Customer.customerDtoEntity(cust);
        return customerDto;
    }

    public Page<Customer> findAll(Pageable page){
        return  customerRepository.findAll(page);
    }

    public List<Customer> findAll(Sort sort){
        return customerRepository.findAll(sort);
    }
}
