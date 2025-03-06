package main;

import models.Car;
import services.CarRentalService;
import ui.CarRentalUI;

public class Main {
    public static void main(String[] args) {
        CarRentalService rentalService = new CarRentalService();

        rentalService.addCar(new Car("C001", "Toyota", "Fortuner", 1500.0));
        rentalService.addCar(new Car("C002", "Honda", "SUV", 2000.0));
        rentalService.addCar(new Car("C003", "Mahindra", "Thar", 1000.0));

        CarRentalUI rentalUI = new CarRentalUI(rentalService);
        rentalUI.start();
    }
}