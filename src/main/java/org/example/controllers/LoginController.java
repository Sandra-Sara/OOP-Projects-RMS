package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private ImageView statusImageView;

    // Method for email validation when typing
    @FXML
    private void onEmailTyped() {
        String email = emailField.getText();
        if (!isValidEmail(email)) {
            emailField.setStyle("-fx-border-color: red;");
            updateStatusImage("error_image.png");
        } else {
            emailField.setStyle("-fx-border-color: green;");
            updateStatusImage("success_image.png");
        }
    }

    // Method for password validation when typing
    @FXML
    private void onPasswordTyped() {
        String password = passwordField.getText();
        if (!isValidPassword(password)) {
            passwordField.setStyle("-fx-border-color: red;");
            updateStatusImage("error_image.png");
        } else {
            passwordField.setStyle("-fx-border-color: green;");
            updateStatusImage("success_image.png");
        }
    }

    // Method for login button action
    @FXML
    private void onLoginButtonClicked() {
        String email = emailField.getText();
        String password = passwordField.getText();

        // Change button color to gradient green after click
        loginButton.setStyle("-fx-background-color: linear-gradient(#43a047, #66bb6a);");

        // Validate email and password
        if (email.isEmpty() || password.isEmpty()) {
            updateStatusImage("error_image.png"); // Show error status image
            System.out.println("Email and password cannot be empty.");
        } else if (!isValidEmail(email)) {
            updateStatusImage("error_image.png"); // Show error status image
            System.out.println("Invalid email format.");
        } else if (!isValidPassword(password)) {
            updateStatusImage("error_image.png"); // Show error status image
            System.out.println("Password must be at least 8 characters long and contain a letter and a number.");
        } else {
            updateStatusImage("success_image.png"); // Show success status image
            System.out.println("Login successful!");
            // Add your login logic here (e.g., authenticate user, navigate to another scene)
        }
    }

    // Utility method to validate email format
    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    // Utility method to validate password
    private boolean isValidPassword(String password) {
        // Example validation: Minimum 8 characters, at least one letter and one number
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        return password != null && password.matches(passwordRegex);
    }

    // Method to update the status image
    private void updateStatusImage(String imageName) {
        try {
            Image image = new Image(getClass().getResourceAsStream("/images/" + imageName));
            statusImageView.setImage(image);
        } catch (Exception e) {
            System.out.println("Error loading image: " + imageName);
        }
    }
}
