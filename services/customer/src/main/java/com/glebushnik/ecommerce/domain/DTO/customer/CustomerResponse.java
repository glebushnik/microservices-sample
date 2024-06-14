package com.glebushnik.ecommerce.domain.DTO.customer;

import com.glebushnik.ecommerce.domain.entity.Address;
import lombok.*;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Address address;
}
