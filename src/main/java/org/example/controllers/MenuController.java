package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;

public class MenuController {

    @FXML
    private Button addNoddles;

    @FXML
    private Button addFC;

    @FXML
    private Button addBg;

    @FXML
    private Button addEs;

    @FXML
    private Button addCKB;

    @FXML
    private Button addHP;

    @FXML
    private Button addCC;

    @FXML
    private Button addFIC;

    @FXML
    private Button addKB;

    @FXML
    private Spinner<Integer> noodlesSpinner;

    @FXML
    private Spinner<Integer> friedChickenSpinner;

    @FXML
    private Spinner<Integer> burgerSpinner;

    @FXML
    private Spinner<Integer> eggSandwichSpinner;

    @FXML
    private Spinner<Integer> chickenBiryaniSpinner;

    @FXML
    private Spinner<Integer> pizzaSpinner;

    @FXML
    private Spinner<Integer> cherryCakeSpinner;

    @FXML
    private Spinner<Integer> friedIceCreamSpinner;

    @FXML
    private Spinner<Integer> kacciBiryaniSpinner;

    @FXML
    public void initialize() {
        // Initialize spinners with default values
        initializeSpinner(noodlesSpinner);
        initializeSpinner(friedChickenSpinner);
        initializeSpinner(burgerSpinner);
        initializeSpinner(eggSandwichSpinner);
        initializeSpinner(chickenBiryaniSpinner);
        initializeSpinner(pizzaSpinner);
        initializeSpinner(cherryCakeSpinner);
        initializeSpinner(friedIceCreamSpinner);
        initializeSpinner(kacciBiryaniSpinner);
    }

    private void initializeSpinner(Spinner<Integer> spinner) {
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
    }

    @FXML
    private void handleAddButtonClick(MouseEvent event) {
        Button clickedButton = (Button) event.getSource();
        String item = "";
        int quantity = 0;

        if (clickedButton == addNoddles) {
            item = "Spicy Noodles";
            quantity = noodlesSpinner.getValue();
        } else if (clickedButton == addFC) {
            item = "Fried Chicken";
            quantity = friedChickenSpinner.getValue();
        } else if (clickedButton == addBg) {
            item = "Burger";
            quantity = burgerSpinner.getValue();
        } else if (clickedButton == addEs) {
            item = "Egg Sandwich";
            quantity = eggSandwichSpinner.getValue();
        } else if (clickedButton == addCKB) {
            item = "Chicken Kacci Biryani";
            quantity = chickenBiryaniSpinner.getValue();
        } else if (clickedButton == addHP) {
            item = "Hot Pizza";
            quantity = pizzaSpinner.getValue();
        } else if (clickedButton == addCC) {
            item = "Cherry Cake";
            quantity = cherryCakeSpinner.getValue();
        } else if (clickedButton == addFIC) {
            item = "Fried Ice Cream";
            quantity = friedIceCreamSpinner.getValue();
        } else if (clickedButton == addKB) {
            item = "Kacci Biryani";
            quantity = kacciBiryaniSpinner.getValue();
        }

        // Handle the addition logic (e.g., add to cart or update UI)
        System.out.println("Added " + quantity + " x " + item + " to the cart.");
    }
}
