package com.deepammali.garbage_backend.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> maybeCustomer = customerRepository.findByEmail(customer.getEmail());
        if (maybeCustomer.isPresent()) {
            throw new IllegalStateException("Customer Exists");
        }
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
