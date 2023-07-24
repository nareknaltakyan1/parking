package com.ultralabs.parking.rest.endpoint.parking;

import com.ultralabs.parking.domain.parking.service.ParkingService;
import com.ultralabs.parking.rest.api.parking.CreateParkingRequestDto;
import com.ultralabs.parking.rest.api.parking.ParkingApi;
import com.ultralabs.parking.rest.api.parking.ParkingBookRequestDto;
import com.ultralabs.parking.rest.api.parking.ParkingResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ParkingController implements ParkingApi {

    private final ParkingService parkingService;
    private final ParkingConverter parkingConverter;

    @Override
    public ResponseEntity<List<ParkingResponseDto>> getParkingList(final Boolean onlyFrees) {
        return ResponseEntity.ok(List.of(ParkingResponseDto.builder()
                .withId(1l)
                .withUserId(1l)
                .withBookedFrom(LocalDateTime.now())
                .withBookedTo(LocalDateTime.now())
                .build()));
    }

    @Override
    public ResponseEntity<ParkingResponseDto> book(final ParkingBookRequestDto requestDto) {
        final var details = parkingConverter.convertRequestDtoToDetails(requestDto);
        final var parking = parkingService.book(details);
        return ResponseEntity.ok(parkingConverter.convertEntityToResponseDto(parking));
    }

//    @Override
//    public ResponseEntity<?> park() {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<?> release() {
//        return null;
//    }
}
