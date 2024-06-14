package com.glebushnik.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundByIdException extends RuntimeException{
    private final String msg;
}
