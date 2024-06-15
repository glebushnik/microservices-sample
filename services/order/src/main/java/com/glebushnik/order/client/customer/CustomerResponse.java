package com.glebushnik.order.client.customer;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CustomerResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
