package ra.custome_validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ra.custome_validator.impl.MedCodeValidator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MedCodeValidator.class)
@Documented
public @interface MedCode {
    String message() default "Mã khoa phải bắt đầu bằng 'MED_'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
