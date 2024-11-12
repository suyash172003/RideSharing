package org.example.rideservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RideModel {

    @Id
    private String rideId;
    private String pickupLocation;
    private String dropoffLocation;
    private String status;
}
