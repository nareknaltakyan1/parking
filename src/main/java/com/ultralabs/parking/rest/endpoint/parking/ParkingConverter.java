package com.ultralabs.parking.rest.endpoint.parking;

import com.ultralabs.parking.domain.parking.model.Parking;
import com.ultralabs.parking.domain.parking.model.ParkingBookDetails;
import com.ultralabs.parking.rest.api.parking.ParkingBookRequestDto;
import com.ultralabs.parking.rest.api.parking.ParkingResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ParkingConverter {

    public ParkingResponseDto convertEntityToResponseDto(final Parking parking) {
        return ParkingResponseDto.builder()
                .withId(parking.getId())
                .withUserId(parking.getUserId())
                .withBookedFrom(LocalDateTime.from(parking.getBookedFrom()))
                .withBookedTo(LocalDateTime.from(parking.getBookedTo()))
                .build();
    }

    public ParkingBookDetails convertRequestDtoToDetails(final ParkingBookRequestDto requestDto) {
        return ParkingBookDetails.builder()
                .withId(requestDto.getId())
                .withUserId(requestDto.getUserId())
                .withBookedFrom(requestDto.getBookedFrom())
                .withBookedTo(requestDto.getBookedTo())
                .build();
    }
}
