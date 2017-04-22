package example11.com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jorgeotero on 4/18/17.
 */
public class CreditorTest {

    private Creditor creditor;

    @Before
    public void setUp() throws Exception {
        creditor = new Creditor();
    }

    @Test
    public void addingFundsIncrementsAvailableFunds() throws Exception {
        creditor.addFunds(25);
        creditor.addFunds(25);

        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    public void theStartingCreditAvailableIs0() throws Exception {
        assertEquals(0, creditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() throws Exception {
        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(10, refund);
    }

    @Test(expected = NotEnoughFundsException.class)
    public void deductMoreThanFundsAvailableIsNotAllowed() throws Exception {
        creditor.deduct(100);
    }
}