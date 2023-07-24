package com.ultralabs.parking.rest.api.parking;

import lombok.Value;

import java.time.Instant;
import java.time.LocalDateTime;

@Value
public class ParkingBookRequestDto {
    Long id;
    Long userId;
    LocalDateTime bookedFrom;
    LocalDateTime bookedTo;
}
