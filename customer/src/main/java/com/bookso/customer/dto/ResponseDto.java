package com.bookso.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

/*
* author: santhosh kumar
* description: ResponseDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String code;
    private String message;
}
