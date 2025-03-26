/**
 *  {@code Garage} represented as a class to store the Strings in the garage.
 */
public class GarageProofOfConcept {
    /**
     * The array of Strings to store the cars in the garage.
     */
    private String[] cars;
    /**
     * The number of cars in the garage.
     */
    private int count;

    /**
     * Constructs a new {@code Garage} object with the given size.
     * @param size the size of the garage
     */
    public GarageProofOfConcept(int size) {
        this.cars = new String[size];
        this.count = 0;
    }

    /**
     * Adds a String to the garage.
     * @param carToAdd the String to be added
     */
    public void addCar(String carToAdd) {
        if (this.count < this.cars.length) {
            this.cars[this.count] = carToAdd;
            this.count++;
        }
    }

    /**
     * Empties the garage.
     */
    public void emptyGarage() {
        for (int i = 0; i < this.count; i++) {
            this.cars[i] = "";
        }
        this.count = 0;
    }

    /**
     * Removes a String from the garage.
     * @param carToRemove the car to be removed
     */
    public void removeCar(String carToRemove) {
        for (int i = 0; i < this.count; i++) {
            if (this.cars[i].equals(carToRemove)) {
                this.cars[i] = this.cars[this.count - 1];
                this.cars[this.count - 1] = null;
                this.count--;
                break;
            }
        }
    }
    /**
     * Main method to test the {@code Garage} class.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        final int garageSize = 5;
        GarageProofOfConcept garage = new GarageProofOfConcept(garageSize);
        garage.addCar("Toyota");
        garage.addCar("Mercedes");
        garage.addCar("Audi");
        garage.removeCar("BMW");
        garage.removeCar("Audi");
        garage.addCar("Ford");
        garage.emptyGarage();
    }
}
