import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.CabInvoiceGenerator;
import com.example.*;

public class InvoiceServiceTest{

    @Test
    public void testCalculateFare(){
            CabInvoiceGenerator cabInvoiceGEnerator = new CabInvoiceGenerator();
            double fare = cabInvoiceGEnerator.CalculateFare(5,15);
            assertEquals(65.0, fare);  //5km * 10 rs + 15 min * 1 rs/min
    }

    @Test
    public void minimumFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double fare = cabInvoiceGenerator.CalculateFare(0.1, 1);
        System.out.println(fare);
        assertEquals(5.0, fare);
    }

    @Test

    public void multipleRides()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = {new Ride(2,5),new Ride(0.1,1)};
        double fare = cabInvoiceGenerator.CalculateFare(rides);
        assertEquals(30,fare);
    }

}