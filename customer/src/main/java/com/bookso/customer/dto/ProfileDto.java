package com.bookso.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
* author: santhosh kumar
* description: ProfileDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {


    private Long customerId;
    private String subscriptionType;
    private String subscriptionDuration;
    private LocalDate subscribedOn;
    private LocalDate validTill;
}
