package com.module2.springBootWebTutorial.springBootWeb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.module2.springBootWebTutorial.springBootWeb.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Age cannot be null")
    @Max(value = 80, message = "Age must be less than or equal to 80")
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private Integer age;

    @NotBlank(message = "Role cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role must be either ADMIN or USER")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be positive")
    @Digits(integer = 6, fraction = 2, message = "Salary can be in the form XXXXX.YY")
    @DecimalMin(value = "100.50")
    @DecimalMax(value = "100000.99")
    private Double salary;

    @PastOrPresent(message = "Date of joining must be in the past or present")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee must be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
