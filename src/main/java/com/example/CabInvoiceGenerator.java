package com.example;

import java.util.*;

public class CabInvoiceGenerator {

    static Map<String, ArrayList<Ride>> ridesList;
    static final double COST_PER_MINUTE = 1.0;
    static final double COST_PER_KM = 10.0;
    static final double MINIMUM_FARE = 5.0;

    public CabInvoiceGenerator() {
        ridesList = new HashMap<String, ArrayList<Ride>>();
    }

    public void addRides(String user_id, Ride ride) {
        if (ridesList.containsKey(user_id) == false) {
            ridesList.put(user_id, new ArrayList<Ride>());
        }
        ridesList.get(user_id).add(ride);
    }

    public double CalculateFare(double distance, double time, String type) {
        //System.out.println(type);
        if (type == "normal") {
            double total_fare = distance * COST_PER_KM + time * COST_PER_MINUTE;
            //System.out.println(total_fare);
            return Math.max(total_fare, 5.0);
        } else {
            double total_fare = distance * 15 + time * 2;
            //System.out.println(total_fare);
            return Math.max(total_fare, 20);
        }
    }

    public InvoiceSummary CalculateFare(Ride[] rides) {
        double fare = 0;
        for (Ride ride : rides) {
            fare += CalculateFare(ride.distance, ride.time,ride.type);
        }

        InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, fare);
        return invoiceSummary;
    }

    public InvoiceSummary getInvoiceReport(String user_id) {
        if (ridesList.containsKey(user_id) == false) {
            return new InvoiceSummary(0, 0);
        }

        ArrayList<Ride> rides = ridesList.get(user_id);
        double fare = 0;
        for (Ride ride : rides) {
            fare += CalculateFare(ride.distance, ride.time,ride.type);
        }

        return new InvoiceSummary(rides.size(), fare);
    }
}
