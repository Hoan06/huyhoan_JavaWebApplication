package ra.custome_validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import ra.custome_validator.impl.MultipleOfTenThousandValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = MultipleOfTenThousandValidator.class)
public @interface MultipleOfTenThousand {
    String message() default "Số tiền rút phải từ 50,000 VNĐ và là bội số của 10,000 VNĐ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
