package org.example.locationservice.service;

import org.example.locationservice.model.DistanceModel;
import org.example.locationservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LocationServices {

    @Autowired
    private LocationRepository locationRepository ;

    public void calculateDistance(DistanceModel distanceModel) {
        double earthRadius = 6371000;
        double lat1 = distanceModel.getSourceLatitude();
        double lon1 = distanceModel.getSourceLongitude();
        double lat2 = distanceModel.getDestinationLatitude();
        double lon2 = distanceModel.getDestinationLongitude();
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = earthRadius * c;
        distanceModel.setRideId(UUID.randomUUID().toString());
        distanceModel.setTotalDistance(d);
        locationRepository.save(distanceModel);
    }

    public double calculateFare(String rideId) {
        DistanceModel rideDetails = locationRepository.getReferenceById(rideId);
        double distanceFare;
        double costPerKilometer = 800000000.0;
        distanceFare = rideDetails.getTotalDistance() * costPerKilometer;
        System.out.println("Distance Fare: " + distanceFare);
        System.out.println("Total Distance: " + rideDetails.getTotalDistance());

        return distanceFare;
    }
}
