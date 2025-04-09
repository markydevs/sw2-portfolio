import components.sequence.Sequence2L;

/**
 * {@code Garage} represented as a sequence of cars with implementation of the
 * GarageKernel interface.
 *
 * @convention |this| <= capacity() and |this| >= 0
 * @correspondence this = [car1, car2, ..., carN] where N = |this| and 0 <= i < N
 */
public class GarageOnSequence extends GarageSecondary {
    // Representation of {@code this}

    private Sequence2L<String> cars;
    private int count;
    private int capacity;

    private void createNewRep() {
        this.cars = new Sequence2L<>();
        this.count = 0;
        this.capacity = 0;
    }
    public GarageOnSequence() {
        this.createNewRep();
    }
    public GarageOnSequence(int capacity) {
        this.createNewRep();
        this.capacity = capacity;
    }

    /**
     * Standard Methods
     */
    @Override
    public final Garage newInstance() {
        Garage garage = new GarageOnSequence(this.capacity);
        for (int i = 0; i < this.count(); i++) {
            garage.addCar(this.carAt(i));
        }
        return garage;
    }
    @Override
    public final void clear() {
        this.createNewRep();
    }
    @Override
    public final void transferFrom(Object garage) {
        GarageOnSequence g = (GarageOnSequence) garage;
        this.cars = (Sequence2L<String>) g.cars.newInstance();
        this.count = g.count;
        this.capacity = g.capacity;
    }


    /**
     * GarageKernel Methods
     */
    @Override
    public final void addCar(String carToAdd) {
        assert this.count < this.capacity : "Garage is full";
        this.cars.add(this.count, carToAdd);
        this.count++;
    }
    @Override
    public final void removeCar(String carToRemove) {
        assert this.count > 0 : "Garage is empty";
        int index = this.indexOf(carToRemove);
        assert index != -1 : "Car not found in garage";
        this.cars.remove(index);
        this.count--;
    }
    @Override
    public final String carAt(int index) {
        assert index >= 0 && index < this.count : "Index out of bounds";
        return this.cars.entry(index);
    }
    @Override
    public final int count() {
        return this.count;
    }
    @Override
    public final int capacity() {
        return this.capacity;
    }
    @Override
    public final String toString() {
        return this.cars.toString();
    }

    @Override
    public final boolean isFull(Garage garage) {
        return this.count == garage.capacity();
    }
}