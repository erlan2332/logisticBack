package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // 🔹 Предотвращаем ошибки сериализации
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String model;
    private String calibration;
    private String colorVariant;

    @OneToMany(mappedBy = "truck", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("truck") // 🔹 Исключаем обратную связь JSON
    private List<Trip> trips;

    // ✅ Конструкторы, геттеры и сеттеры
    public Truck() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getCalibration() { return calibration; }
    public void setCalibration(String calibration) { this.calibration = calibration; }

    public String getColorVariant() { return colorVariant; }
    public void setColorVariant(String colorVariant) { this.colorVariant = colorVariant; }

    public List<Trip> getTrips() { return trips; }
    public void setTrips(List<Trip> trips) { this.trips = trips; }
}
