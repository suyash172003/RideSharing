package org.example.locationservice.controller;

import org.example.locationservice.model.DistanceModel;
import org.example.locationservice.service.LocationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    LocationServices locationServices;

    @PostMapping("/calculateDistance")
    public ResponseEntity<String> distanceBetweenTwoPoints(@RequestBody DistanceModel distance){
        locationServices.calculateDistance(distance);
        return ResponseEntity.status(HttpStatus.CREATED).body("Distance Calculated");
    }

    @GetMapping("/ETA/{rideId}")
    public double getETA(@PathVariable String rideId){
        return locationServices.calculateFare(rideId);
    }
}
