package com.bookso.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewCustomerDto {

    private String name;
    @Email(message = "Invalid Email id")
    private String email;
    @Pattern(regexp = "\\d{10}" ,message = "Invalid mobile number")
    private String contact;
}
