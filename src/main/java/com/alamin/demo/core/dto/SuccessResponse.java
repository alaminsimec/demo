package com.alamin.demo.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse<T>{
    private int statusCode;
    private String statusMessage;
    private String message;
    private T data;
}
