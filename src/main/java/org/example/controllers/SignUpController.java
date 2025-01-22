package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SignUpController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField streetAddressField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField regionField;

    @FXML
    private TextField postalField;

    @FXML
    private Label firstNameErrorLabel;

    @FXML
    private Label lastNameErrorLabel;

    @FXML
    private Label phoneErrorLabel;

    @FXML
    private Label emailErrorLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private void onSignUpButtonClicked(ActionEvent event) {
        try {
            // Collect input data
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();
            String streetAddress = streetAddressField.getText().trim();
            String city = cityField.getText().trim();
            String region = regionField.getText().trim();
            String postal = postalField.getText().trim();

            // Validate input data
            if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() ||
                    streetAddress.isEmpty() || city.isEmpty() || region.isEmpty() || postal.isEmpty()) {
                showAlert("Validation Error", "All fields are required.", Alert.AlertType.ERROR);
                return;
            }

            if (!phone.matches("\\+8801\\d{9}")) {
                showAlert("Validation Error", "Invalid phone number format. Expected: +8801#########", Alert.AlertType.ERROR);
                return;
            }

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                showAlert("Validation Error", "Invalid email address.", Alert.AlertType.ERROR);
                return;
            }

            // Simulate user registration (you can replace this with actual database logic)
            showAlert("Success", "User registered successfully!", Alert.AlertType.INFORMATION);

            // Clear the form fields after successful registration
            clearFormFields();
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void onFieldTyped() {
        validateTextField(firstNameField, firstNameErrorLabel, "First name cannot be empty.");
        validateTextField(lastNameField, lastNameErrorLabel, "Last name cannot be empty.");
        validateTextField(phoneField, phoneErrorLabel, "Invalid phone number format. Expected: +8801#########", "\\+8801\\d{9}");
        validateTextField(emailField, emailErrorLabel, "Invalid email address.", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    @FXML
    private void onImageViewClicked() {
        // Example logic: Update the image view with a new image
        imageView.setImage(new Image(getClass().getResource("/images/Food-Delivery-1.png").toExternalForm()));
    }

    private void validateTextField(TextField textField, Label errorLabel, String errorMessage) {
        if (textField.getText().trim().isEmpty()) {
            errorLabel.setText(errorMessage);
        } else {
            errorLabel.setText("");
        }
    }

    private void validateTextField(TextField textField, Label errorLabel, String errorMessage, String regex) {
        if (!textField.getText().trim().matches(regex)) {
            errorLabel.setText(errorMessage);
        } else {
            errorLabel.setText("");
        }
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void clearFormFields() {
        firstNameField.clear();
        lastNameField.clear();
        phoneField.clear();
        emailField.clear();
        streetAddressField.clear();
        cityField.clear();
        regionField.clear();
        postalField.clear();

        // Clear error labels
        firstNameErrorLabel.setText("");
        lastNameErrorLabel.setText("");
        phoneErrorLabel.setText("");
        emailErrorLabel.setText("");
    }
}


