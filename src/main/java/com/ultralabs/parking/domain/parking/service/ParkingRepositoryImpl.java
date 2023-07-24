package com.ultralabs.parking.domain.parking.service;

import com.ultralabs.parking.domain.parking.model.Parking;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import static org.springframework.util.Assert.notNull;

public class ParkingRepositoryImpl implements ParkingRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Parking> findByIdWithPessimisticLock(final Long id) {
        notNull(id, "Parking id should not be null");
        entityManager.flush();
        final var record = entityManager.find(Parking.class, id, LockModeType.PESSIMISTIC_WRITE);
        if (record != null)
        {
            entityManager.refresh(record);
            return Optional.of(record);
        }
        return Optional.empty();
    }
}
