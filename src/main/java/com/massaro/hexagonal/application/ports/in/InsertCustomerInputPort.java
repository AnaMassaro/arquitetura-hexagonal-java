package com.massaro.hexagonal.application.ports.in;

import com.massaro.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    String insert(Customer customer, String zipCode);
}
