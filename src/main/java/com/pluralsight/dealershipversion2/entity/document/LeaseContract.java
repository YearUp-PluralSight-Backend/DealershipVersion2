package com.pluralsight.dealershipversion2.entity.document;

import com.pluralsight.dealershipversion2.entity.vehicle.Car;

/**
 * Represents a lease contract for a car.
 */
public class LeaseContract extends Contract {

    // The expected ending value of the car at the end of the lease
    private double exceptedEndingValue;

    // The fee associated with the lease
    private double leaseFee;

    /**
     * Constructs a LeaseContract with the specified details.
     *
     * @param date          the date of the contract
     * @param name          the name of the lessee
     * @param email         the email of the lessee
     * @param carSold       the car being leased
     * @param totalPrice    the total price of the lease
     * @param monthlyPayment the monthly payment amount
     */
    public LeaseContract(String date, String name, String email, Car carSold, double exceptedEndingValue, double leaseFee, double totalPrice, double monthlyPayment) {
        super(date, name, email, carSold, totalPrice, monthlyPayment);
        this.exceptedEndingValue = exceptedEndingValue;  // carSold.getPrice() * 0.5;
        this.leaseFee = leaseFee; // carSold.getPrice() * 0.07;
    }

    /**
     * Default constructor for LeaseContract.
     */
    public LeaseContract() {
    }

    /**
     *
     * @return ending value of the vehicle
     */
    public double getExceptedEndingValue() {
        return carSold.getPrice() * 0.5;
    }

    /**
     *
     * @return lease fee
     */
    public double getLeaseFee() {
        return carSold.getPrice() * 0.07;
    }

    /**
     * Calculates and returns the total price of the lease contract.
     *
     * @return the total price of the lease contract
     */
    @Override
    public double getTotalPrice() {
        return getMonthlypayment() * 36;
    }

    /**
     * Calculates and returns the monthly payment amount for the lease.
     *
     * @return the monthly payment amount for the lease
     */
    @Override
    public double getMonthlypayment() {
        double monthlyPayment = 0;
        monthlyPayment = (carSold.getPrice() * (0.04 / 12) / Math.pow(1 - (1 + 0.04 / 12), 36));
        return monthlyPayment;
    }

    /**
     * Return a formatted contract string.
     * @return contract
     */
    @Override
    public String toString() {
        return String.format(
                "SALE | %-10s | %-15s | %-15s | %-6d | %-4d | %-10s | %-10s | %-4s | %-10s | %,10d | $%,10.2f | $%,10.2f | $%,10.2f | $%,10.2f | $%,10.2f",
                super.getDate(), super.getName(), super.getEmail(), carSold.getVin(), carSold.getYear(),
                carSold.getMake(), carSold.getModel(), carSold.getVehicleType(), carSold.getColor(),
                carSold.getOdometer(), carSold.getPrice(), this.exceptedEndingValue, this.leaseFee,
                 this.getTotalPrice(),  this.getMonthlypayment()
        );
    }

}