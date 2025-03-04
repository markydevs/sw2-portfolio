import components.standard.Standard;

/**
 * The GarageKernel interface provides methods to add and remove cars from a garage,
 * as well as to report the capacity of the garage.
 */
public interface GarageKernel extends Standard<Object> {
    /**
     * Adds a String car to the garage.
     * @param carToAdd the String to be added
     * @updates this
     * @ensures this contains carToAdd
     */
    void addCar(String carToAdd);

    /**
     * Removes a String from the garage.
     * @param carToRemove the car to be removed
     * @updates this
     * @ensures this does not contain carToRemove
     */
    void removeCar(String carToRemove);

    /**
     * Reports the size of the garage.
     * @return the size of the garage
     * @ensures capacity = |this|
     */
    int capacity();
 }
