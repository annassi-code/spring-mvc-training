package com.application.validator;

import com.application.entity.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "product.name", "You must specify a name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "product.price", "You must specify a price");
    }
}
