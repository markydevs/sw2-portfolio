/**
 * The {@code Garage} interface represents a garage with a specified size.
 * It extends the {@code GarageKernel} interface and provides a method to create a garage.
 */
public interface Garage extends GarageKernel {
    /**
     * Empty the garage.
     * @updates this
     * @ensures this = <>
     */
    void emptyGarage();
    /**
     * Reports whether the garage is full.
     * @param garage the garage to check
     * @return true if the garage is full, false otherwise
     * @ensures isFull = (|garage| = garage.capacity())
     */
    boolean isFull(Garage garage);
    /**
     * Reports the number of cars in the garage.
     * @return the number of cars in the garage
     * @ensures count = |this|
     */
    int count();
    /**
     * Reports the car at the given index.
     * @param index the index of the car to report
     * @return the car at the given index
     * @requires 0 <= index < |this|
     * @ensures carAt = this[index]
     */
    String carAt(int index);
    /**
     * Reports the index of the given car.
     * @param car the car to find
     * @return the index of the given car, or -1 if the car is not in the garage
     * @ensures indexOf = (if car is in this then the index of car in this else -1)
     */
    int indexOf(String car);
    /**
     * Swaps the cars at the given indices.
     * @param index1 the index of the first car
     * @param index2 the index of the second car
     * @updates this
     * @requires 0 <= index1 < |this| and 0 <= index2 < |this|
     * @ensures this = #this[ index1 := @this[index2] and index2 := @this[index1] ]
     */
    void swapCars(int index1, int index2);
    /**
     * Reverses the order of the cars in the garage.
     * @updates this
     * @ensures this = rev(this)
     */
    void reverseCars();

}
