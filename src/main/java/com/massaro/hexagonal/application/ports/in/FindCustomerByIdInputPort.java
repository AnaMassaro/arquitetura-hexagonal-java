package com.massaro.hexagonal.application.ports.in;

import com.massaro.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
