import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.CabInvoiceGenerator;

public class InvoiceServiceTest{

    @Test

    public void testCalculateFare(){
            CabInvoiceGenerator cabInvoiceGEnerator = new CabInvoiceGenerator();
            double fare = cabInvoiceGEnerator.CalculateFare(5,15);
            assertEquals(65.0, fare);  //5km * 10 rs + 15 min * 1 rs/min
    }
}