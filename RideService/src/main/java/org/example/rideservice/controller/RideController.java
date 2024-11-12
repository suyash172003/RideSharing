package org.example.rideservice.controller;

import org.example.rideservice.model.RideModel;
import org.example.rideservice.service.RideServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RideController {

    @Autowired
    private RideServices rideServices;

    @PostMapping("/bookRide")
    public ResponseEntity<String> bookRide(@RequestBody RideModel rideModel) {
        rideServices.bookRide(rideModel);
        return ResponseEntity.ok("Ride booked");
    }

    @GetMapping("/rideStatus/{rideId}")
    public  RideModel getRideStatus(@PathVariable String rideId) {
        return rideServices.rideStatus(rideId);
    }
}
