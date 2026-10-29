package extra;

//The API Interface
public interface InventoryService {
    // Check if the requested quantity of an item is in stock
    StockStatus checkStock(ItemID itemID, int quantity);
    
    // Reserve the item for the requested quantity
    ItemReservation reserveItem(ItemID itemID, int quantity);
}
/**
 * public interface InventoryService {
    boolean checkStock(String itemID, int quantity);
    boolean reserveItem(String itemID, int quantity);
}
 */