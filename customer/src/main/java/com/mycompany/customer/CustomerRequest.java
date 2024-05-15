package com.mycompany.customer;

public record CustomerRequest (
        String firstName,
        String lastName,
        String email
) {

}
