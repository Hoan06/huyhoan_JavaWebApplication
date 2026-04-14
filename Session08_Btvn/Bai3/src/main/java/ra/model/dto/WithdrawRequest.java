package ra.model.dto;

import jakarta.validation.constraints.NotNull;
import ra.custome_validator.MultipleOfTenThousand;

public class WithdrawRequest {

    @NotNull(message = "Số tiền rút không được để trống")
    @MultipleOfTenThousand
    private Long withdrawAmount;

}