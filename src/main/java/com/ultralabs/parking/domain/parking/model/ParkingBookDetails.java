package com.ultralabs.parking.domain.parking.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

//import static org.springframework.util.Assert.notNull;

@Value
@Builder(setterPrefix = "with")
public class ParkingBookDetails {

    Long id;
    Long userId;
    LocalDateTime bookedFrom;
    LocalDateTime bookedTo;

    public ParkingBookDetails(final Long id, final Long userId, final LocalDateTime bookedFrom, final LocalDateTime bookedTo)
    {
//        notNull(id, "Parking id should not be null");
//        notNull(userId, "Parking userId should not be null");
//        notNull(bookedFrom, "Parking booked from time should not be null");
        this.id = id;
        this.userId = userId;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
    }
}
