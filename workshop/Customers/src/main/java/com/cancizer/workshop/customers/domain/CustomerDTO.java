package com.cancizer.workshop.customers.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
    Integer id;
    String name;
}
