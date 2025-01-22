package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private TextField textnameField; // For the username input

    @FXML
    private TextField emailField; // For the email input

    @FXML
    private Label nameField; // Label for the username field

    @FXML
    private Label emailErrorLabel; // Label for the email field

    @FXML
    private Button signUpButton; // Button for signing up

    /**
     * Method to handle input typing events in the fields.
     * Clears error messages when the user types.
     */
    @FXML
    private void onFieldTyped() {
        nameField.setText("Username:");
        emailErrorLabel.setText("Email address:");
    }

    /**
     * Method to handle the "Sign up" button click.
     * Validates the inputs and performs the sign-up logic.
     */
    @FXML
    private void onSignUpButtonClicked() {
        String username = textnameField.getText().trim();
        String email = emailField.getText().trim();

        boolean isValid = true;

        // Validate username
        if (username.isEmpty()) {
            nameField.setText("Username is required.");
            isValid = false;
        }

        // Validate email
        if (email.isEmpty()) {
            emailErrorLabel.setText("Email is required.");
            isValid = false;
        } else if (!email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            emailErrorLabel.setText("Invalid email format.");
            isValid = false;
        }

        // If validation passes, perform the sign-up logic
        if (isValid) {
            System.out.println("Sign-up successful!");
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
        }
    }
}
