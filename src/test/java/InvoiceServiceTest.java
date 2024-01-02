import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.CabInvoiceGenerator;
import com.example.*;

public class InvoiceServiceTest{

    CabInvoiceGenerator cabInvoiceGenerator = null;
    @BeforeEach
    public void setup()
    {
        CabInvoiceGenerator cabInvoiceGEnerator = new CabInvoiceGenerator();
    }

    @Test
    public void testCalculateFare(){
            
            double fare = cabInvoiceGenerator.CalculateFare(5,15);
            assertEquals(65.0, fare); 
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