package com.glebushnik.product.domain.DTO.error;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
){
}
