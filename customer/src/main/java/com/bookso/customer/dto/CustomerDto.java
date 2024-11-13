package com.bookso.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* author: santhosh kumar
* description: CustomerDto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private String name;
    @Email(message = "Invalid Email")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
    private String contact;
    private String subscriptionType;

}
