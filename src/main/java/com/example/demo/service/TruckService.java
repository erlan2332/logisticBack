package com.example.demo.service;

import com.example.demo.model.Truck;
import com.example.demo.repository.TruckRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TruckService {
    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    public Optional<Truck> getTruckById(Long id) {
        return truckRepository.findWithTripsById(id);
    }

    @Transactional
    public Truck saveTruck(Truck truck) {
        return truckRepository.save(truck);
    }

    @Transactional
    public void deleteTruck(Long id) {
        truckRepository.deleteById(id);
    }
}
