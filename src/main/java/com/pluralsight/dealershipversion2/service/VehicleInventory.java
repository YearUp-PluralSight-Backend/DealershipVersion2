package com.pluralsight.dealershipversion2.service;


import com.pluralsight.dealershipversion2.entity.vehicle.Car;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class VehicleInventory {

    private static VehicleInventory vehicleInventory;
    private final List<Car> inventory;
    private int totalOfVehicles;

    private VehicleInventory() {
        this.inventory = new ArrayList<>();
    }

    public static VehicleInventory getInstance() {
        if (vehicleInventory != null) {
            return vehicleInventory;
        }
        vehicleInventory = new VehicleInventory();
        return vehicleInventory;
    }

    public List<Car> getVehiclesByPrice(double min, double max) {
        return this.inventory.stream()
                .filter(car -> car.getPrice() >= min && car.getPrice() <= max) // Filter by price range
                .toList(); // Collect to list
    }

    // Method to get vehicles by make and model
    public List<Car> getVehiclesByMakeModel(String make, String model) {
        // Implementation here
        return this.inventory.stream()
                .filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model))
                .toList();
    }

    // Method to get vehicles by year range
    public List<Car> getVehiclesByYear(int min, int max) {
        // Implementation here
        return this.inventory.stream()
                .filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max)
                .toList();
    }

    // Method to get vehicles by color
    public List<Car> getVehiclesByColor(String color) {
        // Implementation here
        return this.inventory.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .toList();
    }

    // Method to get vehicles by mileage range
    public List<Car>getVehiclesByMileage(double min, double max) {
        // Implementation here

        return this.inventory.stream()
                .filter(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max)
                .toList();
    }

    // Method to get vehicles by type
    public List<Car> getVehiclesByType(String vehicleType) {
        // Implementation here
        return this.inventory.stream()
                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                .toList();
    }

    // Method to get all vehicles in inventory
    public List<Car>  getAllVehicles() {
        // Implementation here
        return this.inventory;
    }

    // Method to add a vehicle to the inventory
    public boolean addVehicle(Car vehicle) {
        // Implementation here
        totalOfVehicles++;
        return this.inventory.add(vehicle);

    }

    public Optional<Car> getVehicleById(int id) {

        return inventory.stream().filter(car -> car.getVin() == id).findFirst();
    }


    // Method to remove a vehicle from the inventory
    public boolean removeVehicle(Car vehicle) {
        // Implementation here
        totalOfVehicles--;
        return this.inventory.remove(vehicle);
    }

    public boolean removeVehicleById(int vin) {
        // Implementation here
        totalOfVehicles--;

        Car car = inventory.stream().filter(c -> c.getVin() == vin).limit(1).findFirst().get();

        return this.inventory.remove(car);
    }

    public void setTotalOfVehicles() {
        this.totalOfVehicles = this.inventory.size();
    }

}
