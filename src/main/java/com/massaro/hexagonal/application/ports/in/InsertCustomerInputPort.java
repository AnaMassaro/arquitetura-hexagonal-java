package com.massaro.hexagonal.application.ports.in;

import com.massaro.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipCode);
}
