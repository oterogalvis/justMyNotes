package example11.com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jorgeotero on 4/18/17.
 */
public class VendingMachineTest {
    private VendingMachine vendingMachine;

    public class NotifierSub implements Notifier {

        @Override
        public void onSale(Item item) {
            return;
        }
    }

    @Before
    public void setUp() throws Exception {
        Notifier notifier = new NotifierSub();
        vendingMachine = new VendingMachine(notifier, 10, 10, 10);
        vendingMachine.restock("A1", "Twinkies", 10, 30, 75);
        vendingMachine.addMoney(75);
    }

    @Test
    public void vendingWhenStockReturnsItem() throws Exception {
        Item item = vendingMachine.vend("A1");

        assertEquals("Verifying the machine is vending the right item.", "Twinkies", item.getName());
    }

    @Test
    public void vendIncrementRunningSalesTotal() throws Exception {
        Item item = vendingMachine.vend("A1");

        assertEquals("Verify the running sales are incremented when and item is vended.", vendingMachine.getRunningSalesTotal(), item.getRetailPrice());
    }
}