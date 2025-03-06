package services;

import models.Car;
import models.Customer;
import models.Rental;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRentalService {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalService() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(String carId, String customerName, int days) {
        Optional<Car> carOpt = cars.stream().filter(c -> c.getCarId().equals(carId) && c.isAvailable()).findFirst();

        if (carOpt.isEmpty()) {
            System.out.println("\nCar not available or invalid ID.");
            return;
        }

        Car car = carOpt.get();
        Customer customer = customers.stream()
                .filter(c -> c.getName().equalsIgnoreCase(customerName))
                .findFirst()
                .orElseGet(() -> {
                    Customer newCust = new Customer("CUST" + (customers.size() + 1), customerName);
                    customers.add(newCust);
                    return newCust;
                });

        car.rent();
        Rental rental = new Rental(car, customer, days);
        rentals.add(rental);
        System.out.println("\nCar rented successfully!\n" + rental);
    }

    public void returnCar(String carId) {
        Optional<Rental> rentalOpt = rentals.stream().filter(r -> r.getCar().getCarId().equals(carId)).findFirst();

        if (rentalOpt.isEmpty()) {
            System.out.println("\nCar is not rented or invalid ID.");
            return;
        }

        Rental rental = rentalOpt.get();
        rental.getCar().returnCar();
        rentals.remove(rental);
        System.out.println("\nCar returned successfully!");
    }

    public void displayAvailableCars() {
        System.out.println("\nAvailable Cars:");
        cars.stream().filter(Car::isAvailable).forEach(System.out::println);
    }
}