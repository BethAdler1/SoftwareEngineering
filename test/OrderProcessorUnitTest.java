
import org.junit.jupiter.api.Test;
import extra.InventoryService;
import extra.OrderProcessor;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class OrderProcessorUnitTest {
    
    @Test
    void testProcessOrder_InStock() {
        // created mockito mock of InventoryService
        InventoryService mockInventory = mock(InventoryService.class);

        //stub the mock so that checking the stock returns true
        when(mockInventory.checkStock("item1", 2)).thenReturn(true);
        when(mockInventory.reserveItem("item1", 2)).thenReturn(true);

        OrderProcessor processor = new OrderProcessor(mockInventory);
        boolean result = processor.processOrder("item1", 2);

        // Assert that processORder returns true when the item is in stock
        assertTrue(result);
    }

    @Test
    void testProcessOrder_OutOfStock() {
        // created mock of inventory service
        InventoryService mockInventory = mock(InventoryService.class);
        // stub mock so that checking the stock returns false
        when(mockInventory.checkStock("item1", 2)).thenReturn(false);

        OrderProcessor processor = new OrderProcessor(mockInventory);
        boolean result = processor.processOrder("item1", 2);

        // Assert procesOrder returns false when out of stock
        assertFalse(result);
    }
}