# Car Rental System Using Java and OOP Concepts

## Overview

This is a **console-based car rental system** implemented in Java using **Object-Oriented Programming (OOP)** principles. It allows users to:

- Add cars to the system
- Rent and return cars
- View all cars and check availability

The system uses a single Java file and demonstrates modular design and interactive CLI functionality.

---

## Features

- Add cars with ID validation
- Unique car ID format (`CARXXX`)
- Rent and return cars with availability check
- View all cars and filter by availability
- Input validation and error handling
- Logger support for event tracking

---

## OOP Concepts Demonstrated

- **Encapsulation**: Class `Car` uses private fields with public getters/setters.
- **Modularity**: Separation of responsibilities between `Car` class and `CarRentalSystem` logic.
- **Abstraction**: Logical actions like `rent()`, `returnCar()`, and input validation are abstracted into methods.

---

## How to Run

### 1. Compile the program

```bash
javac CarRentalSystem.java
```

### 2. Run the program

```bash
java CarRentalSystem
```

---

## Usage Guide

- **Option 1**: Add a car (Car ID, model, and price)
- **Option 2**: View all cars
- **Option 3**: View only available cars
- **Option 4**: Rent a car by ID
- **Option 5**: Return a car by ID
- **Option 6**: Exit the system

---

## Example Output

```
--- Car Rental System ---
1. Add Car
2. View All Cars
3. View Available Cars
4. Rent a Car
5. Return a Car
6. Exit
Choose an option: 1
Enter Car ID (e.g., CAR001): CAR001
Enter Model Name: Swift
Enter Price per Day: 1200
Car added successfully!
```

---

## Future Enhancements

- Persistent data storage using files or a database
- Add GUI using JavaFX or Swing
- Include customer details for bookings
- Multi-user support with authentication

---

## Developed By

- Shubham Mishra
- Ambar Raj
- Ayush Tiwary
- Shivam Gupta

---

## License

This project is for educational purposes and open-source. You are free to modify and redistribute it with attribution.