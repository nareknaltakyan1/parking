package com.ultralabs.parking.domain.parking.service;

import com.ultralabs.parking.domain.parking.model.Parking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ParkingRepositoryCustom {
    
    Optional<Parking> findByIdWithPessimisticLock(final Long id);

//    Page<Parking> search(final SearchParkingDetails details, final Pageable pageable);
}
