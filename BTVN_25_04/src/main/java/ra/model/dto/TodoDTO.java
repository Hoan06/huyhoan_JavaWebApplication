package ra.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoDTO {
    private Long todoId;
    @NotBlank(message = "Nội dung không được để trống !")
    private String content;
    @FutureOrPresent(message = "Ngày phải từ hiện tại trở đi")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
    private boolean status;
    private String priority;
}

