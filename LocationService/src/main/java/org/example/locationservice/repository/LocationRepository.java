package org.example.locationservice.repository;

import org.example.locationservice.model.DistanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<DistanceModel,String> {
}
