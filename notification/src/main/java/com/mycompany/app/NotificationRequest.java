package com.mycompany.app;

public record NotificationRequest(
        Integer toCustomerId,
        String message,
        String toCustomerName) {



}
