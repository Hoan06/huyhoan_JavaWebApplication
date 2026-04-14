package ra.custome_validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ra.custome_validator.impl.TourValidator;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TourValidator.class)
@Documented
public @interface ValidTour {
    String message() default "Dữ liệu tour không hợp lệ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
