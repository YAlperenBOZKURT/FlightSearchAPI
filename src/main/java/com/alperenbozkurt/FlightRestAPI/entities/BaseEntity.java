package com.alperenbozkurt.FlightRestAPI.entities;

import com.alperenbozkurt.FlightRestAPI.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class BaseEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    private Status status;
    private LocalDateTime createdDateTime;

    @NotBlank(message = "You have to enter a name")
    private String createdBy;

    private LocalDateTime modifiedDateTime;
    private String modifiedBy;

    public BaseEntity() {
        this.status = Status.INSERTED;
        this.createdDateTime = LocalDateTime.now();
        this.modifiedDateTime = null;
        this.modifiedBy = null;
    }
}
