package com.example.demo.controller;

import com.example.demo.model.Trip;
import com.example.demo.model.Truck;
import com.example.demo.service.TripService;
import com.example.demo.service.TruckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    private final TripService tripService;
    private final TruckService truckService;

    public TripController(TripService tripService, TruckService truckService) {
        this.tripService = tripService;
        this.truckService = truckService;
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @PostMapping
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {

        if (trip.getTruck() == null) {
            System.out.println(" Ошибка: truck отсутствует в JSON-запросе!");
            return ResponseEntity.badRequest().body(null);
        }
        if (trip.getTruck().getId() == null) {
            System.out.println(" Ошибка: truck.id отсутствует!");
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Truck> truckOptional = truckService.getTruckById(trip.getTruck().getId());
        if (truckOptional.isEmpty()) {
            System.out.println(" Ошибка: Грузовик с ID " + trip.getTruck().getId() + " не найден!");
            return ResponseEntity.notFound().build();
        }

        trip.setTruck(truckOptional.get());
        Trip savedTrip = tripService.saveTrip(trip);

        System.out.println("✅ Успешно добавлен рейс: " + savedTrip);
        return ResponseEntity.ok(savedTrip);
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        if (tripService.getTripById(id).isPresent()) {
            tripService.deleteTrip(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
