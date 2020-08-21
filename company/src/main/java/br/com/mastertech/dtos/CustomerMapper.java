package br.com.mastertech.dtos;

import br.com.mastertech.model.Customer;
import br.com.mastertech.producer.Company;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CompanyRequest createCadastroRequest){

        Customer customer = new Customer();

        customer.setCnpj(createCadastroRequest.getCnpj());
        customer.setName(createCadastroRequest.getNomeEmpresa());

        return customer;
    }

    public Company toCompany(Customer customer) {
        Company company = new Company();

        company.setCnpj(customer.getCnpj());
        company.setNome(customer.getName());

        return company;
    }
}
