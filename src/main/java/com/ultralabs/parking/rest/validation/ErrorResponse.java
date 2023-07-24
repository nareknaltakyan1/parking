package com.ultralabs.parking.rest.validation;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorResponse
{
    String message;
    LocalDateTime errorTime;
}
