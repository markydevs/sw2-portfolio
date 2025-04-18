import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code GarageKernel} kernel methods.
 */
public class GarageKernelTest {

    @Test
    public void testAddCarEmpty() {
        Garage g = new GarageOnSequence(1);
        Garage gCopy = new GarageOnSequence(1);

        g.addCar("tesla");

        assertEquals(1, g.count());
        assertEquals("tesla", g.carAt(0));
        assertNotEquals(gCopy, g);
    }
    /**
     * Tests adding a car to a garage that is not yet full.
     * Ensures the car is added correctly and the state changes as expected.
     */
    @Test
    public void testAddCarFull() {
        Garage g = new GarageOnSequence(2);
        g.addCar("tesla");
        Garage gCopy = new GarageOnSequence(2);
        gCopy.addCar("tesla");

        g.addCar("ford");

        assertEquals(2, g.count());
        assertEquals("ford", g.carAt(1));
        assertNotEquals(gCopy, g);
    }

    @Test
    public void testRemoveCarOne() {
        Garage g = new GarageOnSequence(2);
        g.addCar("tesla");
        Garage gCopy = new GarageOnSequence(2);
        gCopy.addCar("tesla");

        g.removeCar("tesla");

        assertEquals(0, g.count());
        assertNotEquals(gCopy, g);
    }
    @Test
    public void testRemoveCarMultiple() {
        Garage g = new GarageOnSequence(3);
        g.addCar("tesla");
        g.addCar("ford");
        Garage gCopy = new GarageOnSequence(3);
        gCopy.addCar("tesla");
        gCopy.addCar("ford");

        g.removeCar("tesla");

        assertEquals(1, g.count());
        assertEquals("ford", g.carAt(0));
        assertNotEquals(gCopy, g);
    }

    @Test
    public void testCarAt() {
        Garage g = new GarageOnSequence(1);
        g.addCar("tesla");
        Garage gCopy = new GarageOnSequence(1);
        gCopy.addCar("tesla");

        String car = g.carAt(0);

        assertEquals("tesla", car);
        assertEquals(gCopy, g); // Ensure carAt doesn't modify state
    }

    @Test
    public void testCount() {
        Garage g = new GarageOnSequence(2);
        g.addCar("tesla");
        Garage gCopy = new GarageOnSequence(2);
        gCopy.addCar("tesla");

        int count = g.count();

        assertEquals(1, count);
        assertEquals(gCopy, g); // Ensure count doesn't modify state
    }

    @Test
    public void testCapacity() {
        Garage g = new GarageOnSequence(2);
        Garage gCopy = new GarageOnSequence(2);

        int capacity = g.capacity();

        assertEquals(2, capacity);
        assertEquals(gCopy, g); // Ensure capacity doesn't modify state
    }
}
