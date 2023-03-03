package org.example.servlets.dto;

public class ExceptionDto {
    private String statusCode;
    private String exceptionType;
    private String errorMessage;

    public ExceptionDto(String statusCode, String exceptionType, String errorMessage) {
        this.statusCode = statusCode;
        this.exceptionType = exceptionType;
        this.errorMessage = errorMessage;
    }
}
