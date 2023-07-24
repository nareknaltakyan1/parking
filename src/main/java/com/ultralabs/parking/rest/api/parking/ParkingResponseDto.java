package com.ultralabs.parking.rest.api.parking;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder(setterPrefix = "with")
public class ParkingResponseDto {
    Long id;
    Long userId;
    LocalDateTime bookedFrom;
    LocalDateTime bookedTo;
}
