package com.acadamy.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;


@Builder
public class ResponseDto {

    public  final Object data;
    public  final String message;
    public  final int statusCode;



}
