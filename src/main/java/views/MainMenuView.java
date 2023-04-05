package views;

import java.util.InputMismatchException;

public class MainMenuView extends ConsoleView {

    @Override
    public void show() {
        System.out.println("----WELCOME TO SláinteCare SYSTEM----\n");
        this.askOption(); // Call askOption() method to display menu options
    }

    public void askOption() {
        System.out.println("Choose an option from the list");
        System.out.println("1. Register a new patient");
        System.out.println("2. I'm a doctor");
        System.out.println("3. Exit");

        int option = -1; // Initialize option to -1
        try {
            option = this.scanner.nextInt(); // Read input from user
            this.scanner.nextLine(); // Consume the newline character
        } catch (InputMismatchException exception) {
            System.out.println("\n Invalid input, please input a number");
            this.askOption(); // Call askOption() recursively if invalid input
        }

        switch (option) { // Switch case to handle user's choice
            case 1 -> new CreatePatientView().show(); // If option is 1, create and show CreatePatientView
            case 2 -> new DoctorView().show(); // If option is 2, create and show DoctorView
            case 3 -> System.exit(0); // If option is 3, exit the system with status code 0
            default -> {
                System.out.println("\n Invalid input, choose an option from the menu");
                this.askOption(); // Call askOption() recursively if invalid option
            }
        }

        this.show(); // Call show() method again to display menu options after handling user's choice
    }
}
