package ra.model.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import ra.custome_validator.PriorityValid;
import ra.model.entity.TaskItemEnum;

import java.time.LocalDate;

public class TaskItem {
    @NotNull(message = "Id không được để trống")
    private String id;
    @NotBlank(message = "Tên công việc không được để trống")
    private String title;
    @Future(message = "Phải là một ngày trong tương lai")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate deadline;
    @PriorityValid
    private TaskItemEnum priority;

    public TaskItem() {
    }

    public TaskItem(String id, String title, LocalDate deadline, TaskItemEnum priority) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setPriority(TaskItemEnum priority) {
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public TaskItemEnum getPriority() {
        return priority;
    }
}
