package com.example.SpringDataJPA.entity;

import com.example.SpringDataJPA.dto.CustomerDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private Long PhoneNo;
    private String name;
    @Column(name = "age")
    private Integer age;
    private String gender;
    private String address;
    private Integer planId;

    public static CustomerDto customerDtoEntity(Customer customer){
        CustomerDto a=new CustomerDto();
        a.setPhoneNo(customer.getPhoneNo());
        a.setName(customer.getName());
        a.setAddress(customer.getAddress());
        a.setGender(customer.getGender());
        a.setAddress(customer.getAddress());
        a.setPlanId(customer.getPlanId());
        return  a;
    }
}