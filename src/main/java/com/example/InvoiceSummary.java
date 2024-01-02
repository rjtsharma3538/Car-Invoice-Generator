package com.example;

public class InvoiceSummary {
    public int total_number_of_rides;
    public double fare;
    public double average_fare_per_ride;

    public InvoiceSummary(int total_number_of_rides, double fare)
    {
        this.total_number_of_rides = total_number_of_rides;
        this.fare = fare;
        this.average_fare_per_ride = fare / total_number_of_rides;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceSummary other = (InvoiceSummary) obj;
        if (Double.doubleToLongBits(total_number_of_rides) != Double.doubleToLongBits(other.total_number_of_rides))
            return false;
        if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
            return false;
        if (Double.doubleToLongBits(average_fare_per_ride) != Double.doubleToLongBits(other.average_fare_per_ride))
            return false;
        return true;
    }    
}
