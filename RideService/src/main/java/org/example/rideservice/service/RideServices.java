package org.example.rideservice.service;

import org.example.rideservice.model.RideModel;
import org.example.rideservice.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RideServices {

    @Autowired
    private RideRepository rideRepository;

    public void bookRide(RideModel rideModel) {
        rideModel.setRideId(UUID.randomUUID().toString());
        rideModel.setStatus("upcoming");
        rideRepository.save(rideModel);
    }

    public RideModel rideStatus(String rideId) {
        return rideRepository.findById(rideId).get();
    }

}
