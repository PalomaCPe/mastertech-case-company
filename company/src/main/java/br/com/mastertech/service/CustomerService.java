package br.com.mastertech.service;

import br.com.mastertech.model.Customer;
import br.com.mastertech.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        customer.getCnpj().replace(".","").replace("/","");
        return customerRepository.save(customer);
    }
}
