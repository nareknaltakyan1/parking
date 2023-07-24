package com.ultralabs.parking.domain.parking.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Getter
@Setter
public class Parking {

    @Id
    @Column
    private Long id;

    @Column
    private Long userId;

    @Column
    private Instant bookedFrom;

    @Column
    private Instant bookedTo;

}
