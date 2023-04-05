// Import necessary packages
package com.lucas.slaintecare;

import java.io.FileNotFoundException;
import com.lucas.slaintecare.views.MainMenuView;

// Main class for the Slaintecare application
public class Slaintecare {

    // Main method to start the application
    public static void main(String[] args) throws FileNotFoundException {
        // Display welcome message
        System.out.println("Welcome to SláinteCare");
        
        // Create and display the main menu view
        new MainMenuView().show();
    }
}