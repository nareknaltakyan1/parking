package com.ultralabs.parking.domain.parking.service;

import com.ultralabs.parking.domain.parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long>, ParkingRepositoryCustom {
}
