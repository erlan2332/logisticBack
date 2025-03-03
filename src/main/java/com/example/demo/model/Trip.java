package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String destination;
    private String cargo;
    private String driver;
    private double payment;
    private int weight;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "truck_id", nullable = false)
    @JsonIgnoreProperties("trips") 
    private Truck truck;

    public Trip() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }

    public double getPayment() { return payment; }
    public void setPayment(double payment) { this.payment = payment; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public Truck getTruck() { return truck; }
    public void setTruck(Truck truck) { this.truck = truck; }
}
