package ra.model.dto;


import jakarta.validation.constraints.NotBlank;

public class AddressDto {
    @NotBlank(message = "Vui lòng nhập đầy đủ tên người nhận")
    private String receiverName;
    @NotBlank(message = "Vui lòng nhập đầy đủ địa chỉ")
    private String detailedAddress;

    public AddressDto() {
    }

    public AddressDto(String receiverName, String detailedAddress) {
        this.receiverName = receiverName;
        this.detailedAddress = detailedAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }
}
