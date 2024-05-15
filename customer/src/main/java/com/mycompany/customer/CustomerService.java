package com.mycompany.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private  final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer
                    .builder()
                    .firstName(customerRequest.firstName())
                    .lastName(customerRequest.lastName())
                    .email(customerRequest.email())
                    .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
               FraudCheckResponse.class,
                customer.getId());
        if(fraudCheckResponse.isFrauster() ){
            throw new IllegalStateException("Fraudster");
        }
    }
}
