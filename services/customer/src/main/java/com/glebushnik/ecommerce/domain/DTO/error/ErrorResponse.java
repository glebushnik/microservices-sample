package com.glebushnik.ecommerce.domain.DTO.error;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
){
}
