public class ServiceGarage {
    public static void main(String[] args) {
        // Car Dealership Service Garage
        GarageOnSequence serviceGarage = new GarageOnSequence(4);

        // Cars come in for service
        serviceGarage.addCar("Tesla Model 3");
        serviceGarage.addCar("Honda Accord");
        serviceGarage.addCar("Ford Explorer");

        System.out.println("Cars currently in service:");
        for (int i = 0; i < serviceGarage.count(); i++) {
            System.out.println("- Slot " + i + ": " + serviceGarage.carAt(i));
        }

        // A car gets serviced and leaves
        System.out.println("\nHonda Accord service complete. Removing from garage...");
        serviceGarage.removeCar("Honda Accord");

        // Another car arrives
        System.out.println("\nToyota Camry arrives for service...");
        serviceGarage.addCar("Toyota Camry");

        // Check if garage is full
        System.out.println("\nGarage full? " + serviceGarage.isFull(serviceGarage));

        // Display final state
        System.out.println("\nFinal garage status:");
        for (int i = 0; i < serviceGarage.count(); i++) {
            System.out.println("- Slot " + i + ": " + serviceGarage.carAt(i));
        }
    }
}
