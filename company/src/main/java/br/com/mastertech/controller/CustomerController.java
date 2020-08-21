package br.com.mastertech.controller;

import br.com.mastertech.dtos.CustomerMapper;
import br.com.mastertech.dtos.CompanyRequest;
import br.com.mastertech.model.Customer;
import br.com.mastertech.producer.Company;
import br.com.mastertech.service.CompanyService;
import br.com.mastertech.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Customer createCompany(@RequestBody @Valid CompanyRequest createCompanyRequest){
        Customer customer = customerMapper.toCustomer(createCompanyRequest);
        Company company = customerMapper.toCompany(customer);

        Customer response = customerService.create(customer);
        companyService.sendToKafka(company);

        return response;
    }
}
