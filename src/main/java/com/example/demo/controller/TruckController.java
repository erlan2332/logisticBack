package com.example.demo.controller;

import com.example.demo.model.Truck;
import com.example.demo.service.TruckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = "https://logistic-4y5n.onrender.com") // Фронтенд на Render
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping
    public List<Truck> getAllTrucks() {
        return truckService.getAllTrucks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Truck> getTruckById(@PathVariable Long id) {
        return truckService.getTruckById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Truck addTruck(@RequestBody Truck truck) {
        return truckService.saveTruck(truck);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Truck> updateTruck(@PathVariable Long id, @RequestBody Truck truckDetails) {
        Optional<Truck> truckOptional = truckService.getTruckById(id);
        if (truckOptional.isPresent()) {
            Truck truck = truckOptional.get();
            truck.setNumber(truckDetails.getNumber());
            truck.setModel(truckDetails.getModel());
            truck.setCalibration(truckDetails.getCalibration());
            truck.setColorVariant(truckDetails.getColorVariant());
            return ResponseEntity.ok(truckService.saveTruck(truck));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTruck(@PathVariable Long id) {
        if (truckService.getTruckById(id).isPresent()) {
            truckService.deleteTruck(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
