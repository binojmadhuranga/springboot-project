package com.acadamy.demo.dto;

import lombok.Builder;

@Builder
public class ResponseDto {

    public  final Object data;
    public  final String message;
    public  final int statusCode;



}
