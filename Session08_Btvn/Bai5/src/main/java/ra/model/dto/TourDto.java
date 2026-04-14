package ra.model.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import ra.custome_validator.ValidTour;

import java.time.LocalDate;

@ValidTour
public class TourDto {
    @Pattern(regexp = "^(VN_|INT_)\\d{5}$", message = "Mã Tour phải bắt đầu bằng VN_ hoặc INT_ theo sau là 5 chữ số")
    private String tourCode;

    @Min(value = 1, message = "Giá người lớn phải lớn hơn 0")
    private Double adultPrice;

    @Min(value = 1, message = "Giá trẻ em phải lớn hơn 0")
    private Double childPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Ngày khởi hành không được là quá khứ")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public TourDto() {
    }

    public TourDto(String tourCode, Double adultPrice, Double childPrice, LocalDate startDate, LocalDate endDate) {
        this.tourCode = tourCode;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTourCode() {
        return tourCode;
    }

    public void setTourCode(String tourCode) {
        this.tourCode = tourCode;
    }

    public Double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(Double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public Double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(Double childPrice) {
        this.childPrice = childPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}