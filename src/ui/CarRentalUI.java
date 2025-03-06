package ui;

import services.CarRentalService;
import java.util.Scanner;

public class CarRentalUI {
    private CarRentalService rentalService;
    private Scanner scanner;

    public CarRentalUI(CarRentalService rentalService) {
        this.rentalService = rentalService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. View Available Cars");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> rentCar();
                case 2 -> returnCar();
                case 3 -> rentalService.displayAvailableCars();
                case 4 -> {
                    System.out.println("\nThank you for using the Car Rental System!");
                    return;
                }
                default -> System.out.println("\nInvalid choice. Try again.");
            }
        }
    }

    private void rentCar() {
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();

        rentalService.displayAvailableCars();

        System.out.print("\nEnter car ID to rent: ");
        String carId = scanner.nextLine();

        System.out.print("Enter rental days: ");
        int days = scanner.nextInt();
        scanner.nextLine();

        rentalService.rentCar(carId, name, days);
    }

    private void returnCar() {
        System.out.print("\nEnter car ID to return: ");
        String carId = scanner.nextLine();
        rentalService.returnCar(carId);
    }
}