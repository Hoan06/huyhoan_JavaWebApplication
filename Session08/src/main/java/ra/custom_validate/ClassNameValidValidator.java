package ra.custom_validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClassNameValidValidator implements ConstraintValidator<ClassNameValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        if (value.startsWith("CNTT_")){
            return false;
        }
        return false;
    }
}
