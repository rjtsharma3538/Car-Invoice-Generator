package com.example;

public class CabInvoiceGenerator {

    static final double COST_PER_MINUTE = 1.0;
    static final double COST_PER_KM = 10.0;
    static final double MINIMUM_FARE = 5.0;

    public double CalculateFare(double distance, double time) {
        double total_fare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        return Math.max(total_fare, 5.0);
    }

    // public double CalculateFare(Ride[] rides) {
    //     double fare = 0;
    //     for (Ride ride : rides) {
    //         fare += CalculateFare(ride.distance, ride.time);
    //     }
    //     return fare;
    // }

    public InvoiceSummary CalculateFare(Ride[] rides) {
        double fare = 0;
        for (Ride ride : rides) {
            fare += CalculateFare(ride.distance, ride.time);
        }

        InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length,fare);
        return invoiceSummary;
    }
}
