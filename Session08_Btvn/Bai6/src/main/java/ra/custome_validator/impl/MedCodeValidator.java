package ra.custome_validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ra.custome_validator.MedCode;

public class MedCodeValidator implements ConstraintValidator<MedCode, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }
        return value.startsWith("MED_");
    }
}
