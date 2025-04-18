public class ValetParking {
    public static void main(String[] args) {
        // Create a garage with a capacity of 5
        GarageOnSequence garage = new GarageOnSequence(5);

        // Cars arrive
        garage.addCar("ABC-123"); // Mr. Smith
        garage.addCar("XYZ-789"); // Ms. Lee
        garage.addCar("LMN-456"); // Mr. Patel

        // Display all parked cars
        System.out.println("Current parked cars:");
        for (int i = 0; i < garage.count(); i++) {
            System.out.println("- Spot " + i + ": " + garage.carAt(i));
        }

        // Ms. Lee requests her car
        System.out.println("\nMs. Lee (XYZ-789) is leaving...");
        garage.removeCar("XYZ-789");

        // Check if garage is full
        System.out.println("\nIs garage full? " + garage.isFull(garage));

        // Final state of garage
        System.out.println("\nCars remaining:");
        for (int i = 0; i < garage.count(); i++) {
            System.out.println("- Spot " + i + ": " + garage.carAt(i));
        }
    }
}
