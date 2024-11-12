package org.example.rideservice.repository;

import org.example.rideservice.model.RideModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<RideModel, String> {
}
