package example_11.com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by jorgeotero on 4/18/17.
 */
public class AlphaNumericChooserTest {
    private AlphaNumericChooser alphaNumericChooser;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        alphaNumericChooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        AlphaNumericChooser.Location location = alphaNumericChooser.locationFromInput("B4");

        assertEquals("Asserting that the location match with the right row", 1, location.getRow());
        assertEquals("Asserting that the location match with the right column", 3, location.getColumn());
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingWrongInputIsNotAllowed() throws Exception {
        alphaNumericChooser.locationFromInput("WRONG");
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingLargerThanMaxIsNotAllowed() throws Exception {
        alphaNumericChooser.locationFromInput("Z12");
    }

    @Test
    public void constructingLargerThanAlphabetNotAllowed() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Maximum rows supported is 26");

        new AlphaNumericChooser(27, 10);
    }
}