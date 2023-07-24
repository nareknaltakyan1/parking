package com.ultralabs.parking.domain.system;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

@Service
public class SystemDateTimeService
{

    public LocalDateTime getCurrentDateTime()
    {
        return LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public LocalDateTime getCurrentDateTime(final ZoneId zoneId)
    {
        return LocalDateTime.now(zoneId).truncatedTo(ChronoUnit.MILLIS);
    }

    public LocalDateTime getCurrentDateTime(final TimeZone timeZone)
    {
        return getCurrentDateTime(timeZone.toZoneId());
    }
}
