import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.*;

public class InvoiceServiceTest {

    CabInvoiceGenerator cabInvoiceGenerator = null;

    @BeforeEach
    public void setup() {
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void testCalculateFare() {

        double fare = cabInvoiceGenerator.CalculateFare(5, 15);
        assertEquals(65.0, fare);
    }

    @Test
    public void minimumFare() {
        double fare = cabInvoiceGenerator.CalculateFare(0.1, 1);
        System.out.println(fare);
        assertEquals(5.0, fare);
    }

    @Test
    public void summary() {
        Ride[] rides = { new Ride(2, 5), new Ride(0.1, 1) };
        InvoiceSummary actual = cabInvoiceGenerator.CalculateFare(rides);
        InvoiceSummary expected = new InvoiceSummary(2, 30);
        assertEquals(expected, actual);
    }

    @Test
    public void invoice_service(){
        String user1 = "abc";
        cabInvoiceGenerator.addRides(user1, new Ride(10,6));
        cabInvoiceGenerator.addRides(user1, new Ride(0.2,1));

        InvoiceSummary actual = cabInvoiceGenerator.getInvoiceReport(user1);
        InvoiceSummary expected = new InvoiceSummary(2, 111);

        System.out.println(actual.total_number_of_rides + " " + actual.fare + " " + actual.average_fare_per_ride);

        assertEquals(expected, actual);
    }
}