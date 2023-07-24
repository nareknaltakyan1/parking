package com.ultralabs.parking.rest.api.parking;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;

import java.util.List;

@Tag(name = "Parking", description = "This API parking functionalities to book, park and release parking.")
@RequestMapping("/parking")
public interface ParkingApi {

    @GetMapping
    ResponseEntity<List<ParkingResponseDto>> getParkingList(@RequestParam final Boolean onlyFrees);

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Book parking",
            description = "Books a parking based on a parking state")
    ResponseEntity<ParkingResponseDto> book(@RequestBody final ParkingBookRequestDto requestDto);

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> park();

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> release();

}
