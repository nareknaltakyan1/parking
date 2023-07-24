package com.ultralabs.parking.domain.parking.service;

import com.ultralabs.parking.domain.parking.model.Parking;
import com.ultralabs.parking.domain.parking.model.ParkingBookDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepository repository;

    @Transactional
    public Parking book(final ParkingBookDetails details) {
        final var parking = repository.findByIdWithPessimisticLock(details.getId())
                .orElseThrow(() -> buildEntityNotFoundForIdException(details.getId()));;
        if(Objects.nonNull(parking.getBookedFrom())){
            throw new IllegalStateException(String.format("Unable to book parking for ID '%s'", details.getId()));
        }
        setBookingInfo(details, parking);
        return parking;
    }

    private void setBookingInfo(final ParkingBookDetails details, final Parking parking) {
        parking.setBookedFrom(Instant.from(details.getBookedFrom()));
        parking.setBookedTo(Instant.from(details.getBookedTo()));
        parking.setUserId(details.getUserId());
    }

    private EntityNotFoundException buildEntityNotFoundForIdException(final Long id)
    {
        return new EntityNotFoundException(String.format("Could not find parking with id %s", id));
    }
}
