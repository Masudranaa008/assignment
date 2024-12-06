import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private ShippingService shippingService;

    @InjectMocks
    private OrderService orderService;


    @Test
    void testPlaceOrder() {
        when(shippingService.ship(null,1)).thenReturn(false);
        when(shippingService.ship("item 1",1)).thenReturn(true);

        assertFalse(orderService.placeOrder(null,1));
        assertTrue(orderService.placeOrder("item 1",1));

        verify(shippingService).ship(null,1);
        verify(shippingService).ship("item 1",1);
    }

}