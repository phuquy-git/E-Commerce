package com.laptopshopping.laptopshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private LocalDateTime time = LocalDateTime.now();
    private String errorCode;
    private Object data;
    private String successCode;

    public ResponseDto(String errorCode, Object data, String successCode) {
        this.errorCode = errorCode;
        this.data = data;
        this.successCode = successCode;
    }
}
