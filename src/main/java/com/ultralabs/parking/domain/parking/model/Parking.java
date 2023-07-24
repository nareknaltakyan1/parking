package com.ultralabs.parking.domain.parking.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Parking {

    @Id
    @Column
    private Long id;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "bookedfrom")
    private LocalDateTime bookedFrom;

    @Column(name = "bookedto")
    private LocalDateTime bookedTo;

}
