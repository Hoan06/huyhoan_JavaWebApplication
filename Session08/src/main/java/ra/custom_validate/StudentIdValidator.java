package ra.custom_validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudentIdValidator implements ConstraintValidator<StuIdValid , String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        try {
            Long data = Long.parseLong(value);
            if (data < 0){
                return false;
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
