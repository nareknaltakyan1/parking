package com.ultralabs.parking.rest.validation;

import com.ultralabs.parking.domain.system.SystemDateTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ParkingManagmentServiceExceptionHandler
{
    private final SystemDateTimeService systemDateTimeService;

    public ParkingManagmentServiceExceptionHandler(final SystemDateTimeService systemDateTimeService)
    {
        this.systemDateTimeService = systemDateTimeService;
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleQuoteDoesNotBelongToPartnerException(final IllegalStateException exception)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage(), systemDateTimeService.getCurrentDateTime()));
    }

}
