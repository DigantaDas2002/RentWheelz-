package models;

public class Rental {
    private Car car;
    private Customer customer;
    private int rentalDays;

    public Rental(Car car, Customer customer, int rentalDays) {
        this.car = car;
        this.customer = customer;
        this.rentalDays = rentalDays;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + " | Car: " + car.getBrand() + " " + car.getModel() +
                " | Days: " + rentalDays + " | Total: $" + car.calculatePrice(rentalDays);
    }
}