package ra.custome_validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ra.custome_validator.ValidTour;
import ra.model.dto.TourDto;

public class TourValidator implements ConstraintValidator<ValidTour, TourDto> {
    @Override
    public boolean isValid(TourDto dto, ConstraintValidatorContext context) {
        boolean valid = true;

        if (dto.getAdultPrice() != null && dto.getChildPrice() != null) {
            if (dto.getChildPrice() > dto.getAdultPrice()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Giá trẻ em không được lớn hơn giá người lớn")
                        .addPropertyNode("childPrice").addConstraintViolation();
                valid = false;
            }
        }

        if (dto.getStartDate() != null && dto.getEndDate() != null) {
            if (!dto.getEndDate().isAfter(dto.getStartDate())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Ngày kết thúc phải sau ngày khởi hành")
                        .addPropertyNode("endDate").addConstraintViolation();
                valid = false;
            }
        }
        return valid;
    }
}