package com.bookso.customer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
//Documentation
@Schema(name = "ResponseDto", description = "Schema for ResponseDto")
public class ResponseDto {

    @Schema(description = "Status code of the Response", example = "200")//Documentation
    private String code;

    @Schema(description = "Message of the Response", example = "Customer Created Successfully")//Documentation
    private String message;
}
