package ra.custome_validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ra.custome_validator.ValidEmail;


public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!value.endsWith("@rikkeisort.com") || !value.endsWith("@gmail.com")) {
            return true;
        }
        return false;
    }
}
