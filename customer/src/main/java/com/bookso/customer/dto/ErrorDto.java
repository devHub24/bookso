package com.bookso.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

/*
* author: santhosh kumar
* description: ErrorDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

    private HttpStatus code;
    private String message;
    private String path;
    private LocalDateTime timeStamp;
}
