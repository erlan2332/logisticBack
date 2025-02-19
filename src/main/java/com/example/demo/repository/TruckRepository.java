package com.example.demo.repository;

import com.example.demo.model.Truck;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TruckRepository extends JpaRepository<Truck, Long> {
    @EntityGraph(attributePaths = {"trips"}) // 🔹 Загружаем trips сразу
    Optional<Truck> findWithTripsById(Long id);
}
