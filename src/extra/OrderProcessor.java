package extra;
public class OrderProcessor {
    private final InventoryService inventoryService;

    // Constructor-based Dependency Injection
    public OrderProcessor(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public boolean processOrder(ItemID itemID, Quantity requestedQuantity) {
        // 1. Check if requested quantity is in stock
        StockStatus status = inventoryService.checkStock(itemID, requestedQuantity.getValue());
        
        boolean isAvailable = status.getAvailableQuantity() >= requestedQuantity.getValue();

        // 2. If available, reserve and return true; otherwise return false
        if (isAvailable) {
            inventoryService.reserveItem(itemID, requestedQuantity.getValue());
            return true;
        }
        
        return false;
    }
}
/**
 * What feels like the really obvious way, but that uses primitives
 * public class OrderProcessor {

    private final InventoryService inventoryService;

    public OrderProcessor(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public boolean processOrder(String itemID, int quantity) {
    
    boolean isAvailable = inventoryService.checkStock(itemID, quantity);
        if (!isAvailable) {
            return false;
        }

        return true; // Successfully reserved the item
    }
}
**/

