package ra.custome_validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ra.custome_validator.PriorityValid;
import ra.model.entity.TaskItemEnum; // Import Enum của bạn

public class PriorityValidImpl implements ConstraintValidator<PriorityValid, TaskItemEnum> {
    @Override
    public boolean isValid(TaskItemEnum value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }
}