package ra.model.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private String proId;
    private String proName;
    private String producer;
    private Integer yearMarking;
    private Date experiDate;
    private double price;
}
