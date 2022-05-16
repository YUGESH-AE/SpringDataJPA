package com.example.SpringDataJPA.dto;

import com.example.SpringDataJPA.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
    private Long PhoneNo;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private Integer planId;

    public static Customer customerEntity(CustomerDto customerDto){
        Customer a=new Customer();
        a.setPhoneNo(customerDto.getPhoneNo());
        a.setName(customerDto.getName());
        a.setAddress(customerDto.getAddress());
        a.setGender(customerDto.getGender());
        a.setAddress(customerDto.getAddress());
        a.setPlanId(customerDto.getPlanId());
        return  a;
    }
}
