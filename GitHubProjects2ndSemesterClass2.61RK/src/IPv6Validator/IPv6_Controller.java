package IPv6Validator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class IPv6_Controller {
	
	final private IPv6_Model model;
    final private IPv6_View view;

    public IPv6_Controller(IPv6_Model model, IPv6_View view) {
        this.model = model;
        this.view = view;
        
     // Add listeners and handlers
        addListeners();
    }
    private void addListeners() {
        // Enable the validate button only if IPv6 field is not empty
        view.txtAddress.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                view.btnValidate.setDisable(newValue.trim().isEmpty());
            }
        });
        // Add action for validate button
        view.btnValidate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                validateAddress();
            }
        });
    }
    private void validateAddress() {
        String address = view.txtAddress.getText();
        boolean isValid = model.isValidIPv6(address);

        // Show result
        if (isValid) {
            view.lblResult.setText("Valid IPv6 Address");
            view.lblResult.setStyle("-fx-text-fill: green;");
        } else {
            view.lblResult.setText("Invalid IPv6 Address");
            view.lblResult.setStyle("-fx-text-fill: red;");
        }

        // Optional: Validate port number and show an alert if invalid
        String portText = view.txtPort.getText();
        if (!portText.isEmpty()) {
            try {
                int port = Integer.parseInt(portText);
                if (port < 1 || port > 65535) {
                    showAlert("Port Error", "Port must be a number between 1 and 65535.");
                }
            } catch (NumberFormatException e) {
                showAlert("Port Error", "Port must be a valid integer.");
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
