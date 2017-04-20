package example_11.com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by jorgeotero on 4/18/17.
 */
public class BinTest {
    private Bin bin;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test
    public void restockingWithDifferentItemsIsNotAllowed() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Cannot restock Cheetos with Doritos");

        bin.restock("Cheetos", 1, 100, 50);
        bin.restock("Doritos", 1, 100, 50);
    }

    @Test
    public void whenEmptyPriceIsZero() throws Exception {
        assertEquals("If there is no item price should be 0.", 0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyNameIsNull() throws Exception {
        assertNull("If there is no item item should be null", bin.getItemName());
    }

    @Test
    public void overStockingNotAllowed() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("There are only 10 spots left");

        bin.restock("Cheetos", 2600, 100, 50);

    }
}