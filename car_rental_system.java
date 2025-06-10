import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

class Car {
    private String carId;
    private String model;
    private double pricePerDay;
    private boolean isAvailable;

    public Car(String carId, String model, double pricePerDay) {
        this.carId = carId;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Car ID: " + carId + ", Model: " + model + ", Price/Day: ₹" + pricePerDay +
                ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

public class CarRentalSystem {
    private static Map<String, Car> cars = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(CarRentalSystem.class.getName());

    public static boolean isValidCarId(String id) {
        return id.matches("CAR[0-9]{3}");
    }

    public static boolean isValidModel(String model) {
        return !model.trim().isEmpty();
    }

    public static boolean isValidPrice(double price) {
        return price > 0;
    }

    private static double getValidPrice(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double price = Double.parseDouble(scanner.nextLine());
                if (price > 0) {
                    return price;
                } else {
                    System.out.println("Price must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Please enter a valid number.");
            }
        }
    }

    public static void addCar() {
        try {
            System.out.print("Enter Car ID (e.g., CAR001): ");
            String id = scanner.nextLine();
            if (cars.containsKey(id)) {
                logger.warning("Car ID already exists.");
                System.out.println("Car ID already exists.");
                return;
            }
            if (!isValidCarId(id)) {
                logger.warning("Invalid Car ID format.");
                System.out.println("Invalid Car ID format. Use CARXXX where XXX are digits.");
                return;
            }

            System.out.print("Enter Model Name: ");
            String model = scanner.nextLine();
            if (!isValidModel(model)) {
                logger.warning("Invalid model name.");
                System.out.println("Invalid model name.");
                return;
            }

            double price = getValidPrice("Enter Price per Day: ");
            cars.put(id, new Car(id, model, price));
            logger.info("Car added successfully!");
            System.out.println("Car added successfully!");
        } catch (Exception e) {
            logger.severe("An error occurred while adding a car: " + e.getMessage());
            System.out.println("An error occurred while adding a car.");
        }
    }

    public static void viewCars() {
        try {
            if (cars.isEmpty()) {
                logger.info("No cars in the system.");
                System.out.println("No cars in the system.");
                return;
            }
            for (Car car : cars.values()) {
                System.out.println(car);
            }
        } catch (Exception e) {
            logger.severe("An error occurred while viewing cars: " + e.getMessage());
            System.out.println("An error occurred while viewing cars.");
        }
    }

    public static void rentCar() {
        try {
            System.out.print("Enter Car ID to rent: ");
            String id = scanner.nextLine();
            Car car = cars.get(id);
            if (car == null) {
                logger.warning("Car not found.");
                System.out.println("Car not found.");
            } else if (!car.isAvailable()) {
                logger.warning("Car is already rented.");
                System.out.println("Car is already rented.");
            } else {
                car.rent();
                logger.info("Car rented successfully!");
                System.out.println("Car rented successfully!");
            }
        } catch (Exception e) {
            logger.severe("An error occurred while renting a car: " + e.getMessage());
            System.out.println("An error occurred while renting a car.");
        }
    }

    public static void returnCar() {
        try {
            System.out.print("Enter Car ID to return: ");
            String id = scanner.nextLine();
            Car car = cars.get(id);
            if (car == null) {
                System.out.println("Car not found.");
            } else if (car.isAvailable()) {
                System.out.println("This car is already available.");
            } else {
                car.returnCar();
                System.out.println("Car returned successfully!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while returning a car.");
        }
    }

    // EXTRA FEATURE: Filter cars by availability
    public static void viewAvailableCars() {
        boolean found = false;
        for (Car car : cars.values()) {
            if (car.isAvailable()) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available cars at the moment.");
        }
    }

    public static void mainMenu() {
        while (true) {
            System.out.println("\n--- Car Rental System ---");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3. View Available Cars");
            System.out.println("4. Rent a Car");
            System.out.println("5. Return a Car");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addCar();
                    break;
                case "2":
                    viewCars();
                    break;
                case "3":
                    viewAvailableCars();
                    break;
                case "4":
                    rentCar();
                    break;
                case "5":
                    returnCar();
                    break;
                case "6":
                    System.out.println("Thank you for using Car Rental System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
