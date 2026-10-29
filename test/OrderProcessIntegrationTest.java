
import org.junit.jupiter.api.Test;
import extra.InventoryService;
import extra.OrderProcessor;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderProcessIntegrationTest {
    
    // A real, in-memory implementation of the API
    static class InMemoryInventoryService implements InventoryService {

        private final Map<String, Integer> inventory = new HashMap<>();

        public void addItem(String itemId, int quantity) {
            inventory.put(itemId, quantity);
        }

        @Override
        public boolean checkStock(String itemId, int quantity) {
            return inventory.getOrDefault(itemId, 0) >= quantity;
        }

        @Override
        public boolean reserveItem(String itemId, int quantity) {
            if (!checkStock(itemId, quantity)) {
                return false;
            }

            inventory.put(itemId, inventory.get(itemId) - quantity);
            return true;
        }
    }

    @Test
    void testOrderProcessorWithRealInventory() {
        //instatntiating the InMemoryInventoryService
        InMemoryInventoryService inventory = new InMemoryInventoryService();
        //adding fake inventory to it
        inventory.addItem("item1", 5);
        //pass the inventory into a new OrderProcessor instance
        OrderProcessor processor = new OrderProcessor(inventory);
        //calling processOrder on the OrderProcessor instance
        boolean result = processor.processOrder("item1", 3);

        // Asserting that the order was processed and item quantity was reduced
        assertTrue(result);
        assertEquals(2, inventory.getQuantity("item1"));
    }
}

