import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This class contains unit tests for the GarageSecondary functionality.
 */
public class GarageSecondaryTest {

    /**
     * `isFull()` should flip from false → true when capacity is reached
     * without changing the cars already stored.
     */
    @Test void isFullDetectsCapacity() {
        Garage g = new GarageOnSequence(1); // capacity 1

        GarageSecondary gs = (GarageSecondary) g;
        assertFalse(gs.isFull());

        g.addCar("tesla");
        assertTrue(gs.isFull());
        assertEquals("tesla", g.carAt(0));
    }
    /**
     * `isFull()` should remain false when the garage is not at full capacity.
     */
    @Test void isFullNotFull() {
        Garage g = new GarageOnSequence(2); // capacity 2

        GarageSecondary gs = (GarageSecondary) g;
        assertFalse(gs.isFull());

        g.addCar("tesla");
        assertFalse(gs.isFull());
        assertEquals("tesla", g.carAt(0));
    }

    /**
     * `indexOf()` returns the right index and does not mutate state.
     */
    @Test void indexOfNonMutating() {
        Garage g = new GarageOnSequence(3);
        g.addCar("ford"); g.addCar("honda");

        GarageSecondary gs = (GarageSecondary) g;
        String before = g.toString();

        assertEquals(1, gs.indexOf("honda"));
        assertEquals(before, g.toString()); // state unchanged
    }
    /**
     * `indexOf()` should return -1 when the car is not found and not mutate state.
     */
    @Test void indexOfNotFound() {
        Garage g = new GarageOnSequence(3);
        g.addCar("ford"); g.addCar("honda");

        GarageSecondary gs = (GarageSecondary) g;
        String before = g.toString();

        assertEquals(-1, gs.indexOf("toyota"));
        assertEquals(before, g.toString()); // state unchanged
    }

    /**
     * A quick sanity‑check for `swapCars()`.
     */
    @Test void swapCarsSwaps() {
        Garage g = new GarageOnSequence(2);
        g.addCar("a"); g.addCar("b");

        ((GarageSecondary) g).swapCars(0, 1);

        assertEquals("b", g.carAt(0));
        assertEquals("a", g.carAt(1));
    }

    /**
     * `reverseCars()` should flip the order of an odd‑length list.
     */
    @Test void reverseCarsReverses() {
        Garage g = new GarageOnSequence(3);
        g.addCar("x"); g.addCar("y"); g.addCar("z");

        ((GarageSecondary) g).reverseCars();

        assertEquals("z", g.carAt(0));
        assertEquals("y", g.carAt(1));
        assertEquals("x", g.carAt(2));
    }
    /**
     * `reverseCars()` should flip the order of an even‑length list.
     */
    @Test void reverseCarsReversesEven() {
        Garage g = new GarageOnSequence(4);
        g.addCar("a"); g.addCar("b"); g.addCar("c"); g.addCar("d");

        ((GarageSecondary) g).reverseCars();

        assertEquals("d", g.carAt(0));
        assertEquals("c", g.carAt(1));
        assertEquals("b", g.carAt(2));
        assertEquals("a", g.carAt(3));
    }
    /**
     * Tests that the garage is emptied correctly and its state is reset.
     */
    @Test
    public void testEmptyGarage() {
        Garage g = new GarageOnSequence(3);
        g.addCar("a");
        g.addCar("b");

        g.emptyGarage();

        assertEquals(0, g.count());
        assertEquals("[]", g.toString());
    }

    /**
     * Tests the `toString` method to ensure it returns the correct string representation
     * of the garage and does not modify its state.
     */
    @Test
    public void testToString() {
        Garage g = new GarageOnSequence(2);
        g.addCar("tesla");
        Garage gCopy = new GarageOnSequence(2);
        gCopy.addCar("tesla");

        String str = g.toString();

        assertEquals("[tesla]", str);
        assertEquals(gCopy, g); // Ensure toString doesn't modify state
    }
    /**
     * Tests the `toString` method to ensure it returns "[]" for an empty garage
     * and does not modify its state.
     */
    @Test
    public void testToStringEmpty() {
        Garage g = new GarageOnSequence(2);
        Garage gCopy = new GarageOnSequence(2);

        String str = g.toString();

        assertEquals("[]", str);
        assertEquals(gCopy, g); // Ensure toString doesn't modify state
}
}
