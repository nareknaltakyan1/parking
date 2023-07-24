package com.ultralabs.parking.domain.parking.model;

import lombok.Builder;
import lombok.Value;
//import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Value
@Builder(setterPrefix = "with")
public class ParkingDetails
{
    Long id;
    Long userId;
    LocalDateTime bookedFrom;
    LocalDateTime bookedTo;
    public ParkingDetails(final Long id, final Long userId, final LocalDateTime bookedFrom, final LocalDateTime bookedTo)
    {
//        Assert.notNull(id, "Parking id should not be null");
        this.id = id;
        this.userId = userId;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
    }
}
