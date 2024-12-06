import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    PaymentService paymentService;

    @InjectMocks
    BookingService bookingService;


    @Test
    void testProcessPayment(){
        when(paymentService.processPayment()).thenReturn(true);
        assertTrue(bookingService.book());
        verify(paymentService).processPayment();
    }

}