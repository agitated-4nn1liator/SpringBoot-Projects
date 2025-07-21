package com.module2.springBootWebTutorial.springBootWeb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.module2.springBootWebTutorial.springBootWeb.annotations.PasswordValidation;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Title can not be blank")
    private String title;

    @AssertTrue(message = "Department must be active")
    @JsonProperty("isActive")
    private boolean isActive;

    @PastOrPresent(message = "Date of creation must be in the past or present")
    private LocalDate createdAt;

    @PasswordValidation
    private String password;
}
