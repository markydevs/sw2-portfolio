/**
 * Layered implementations of secondary methods for {@code Garage}.
 */
public abstract class GarageSecondary implements Garage {

    /*
     * Common methods (from Object)
     */
    /**
     * Returns a string representation of the GarageSecondary class.
     * @return a string representation of the garage with all cars in it,
     *         e.g., "[car1, car2, car3]"
     */
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < this.count(); i++) {
            result += this.carAt(i);
            if (i < this.count() - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
    /**
     * Compares the specified object with this garage for equality.
     * @param obj the object to be compared
     * @return true if the specified object is equal to this garage, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            GarageSecondary g = (GarageSecondary) obj;
            if (this.count() == g.count()) {
                result = true;
                for (int i = 0; i < this.count(); i++) {
                    if (!this.carAt(i).equals(g.carAt(i))) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }
    /**
     * Returns a hash code value for the garage.
     * @return a hash code value for the garage
     */
    @Override
    public int hashCode() {
        final int hashMultiplier = 31;
        int result = 1;
        for (int i = 0; i < this.count(); i++) {
            int carHashCode;
            if (this.carAt(i) == null) {
                carHashCode = 0;
            } else {
                carHashCode = this.carAt(i).hashCode();
            }
            result = hashMultiplier * result + carHashCode;
        }
        return result;
    }


    /*
     * Other non-kernel methods
     */
    /**
     * Empties the garage by removing all cars one by one.
     * Subclasses should not override this method to ensure consistent behavior.
     */
    @Override
    public final void emptyGarage() {
        while (this.capacity() > 0) {
            this.removeCar(this.carAt(0));
        }
    }

    /**
     * Reports whether the garage is full.
     * @return true if the garage is full, false otherwise
     */
    public final boolean isFull() {
        return this.count() == this.capacity();
}
    /**
     * Reports the index of the given car.
     * @param car the car to find
     * @return the index of the given car, or -1 if the car is not in the garage
     */
    @Override
    public final int indexOf(String car) {
    int index = 0;
    while (index < this.count() && !this.carAt(index).equals(car)) {
        index++;
    }
    if (index == this.count()) {
        index = -1;
    }
    return index;
}

    /**
     * Swaps the cars at the given indices.
     * @param index1 the index of the first car
     * @param index2 the index of the second car
     */
    @Override
    public final void swapCars(int index1, int index2) {
        String temp = this.carAt(index1);
        this.removeCar(this.carAt(index1));
        this.addCar(this.carAt(index2));
        this.removeCar(this.carAt(index2));
        this.addCar(temp);
    }

    /**
     * Reverses the order of the cars in the garage.
     */
    @Override
    public final void reverseCars() {
        int count = this.count();
        for (int i = 0; i < count / 2; i++) {
            this.swapCars(i, count - i - 1);
        }
    }
}
