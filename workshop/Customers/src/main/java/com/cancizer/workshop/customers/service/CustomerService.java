package com.cancizer.workshop.customers.service;

import com.cancizer.workshop.customers.domain.Customer;
import com.cancizer.workshop.customers.domain.CustomerDTO;
import com.cancizer.workshop.customers.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> CustomerDTO.builder().id(customer.getId()).name(customer.getName()).build())
                .collect(Collectors.toList());
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        final Customer customer = customerRepository.save(Customer.builder().name(customerDTO.getName()).build());
        return CustomerDTO.builder().id(customer.getId()).name(customer.getName()).build();
    }
}
