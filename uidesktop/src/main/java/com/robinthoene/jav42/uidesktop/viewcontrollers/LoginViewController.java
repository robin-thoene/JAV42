package com.robinthoene.jav42.uidesktop.viewcontrollers;

import com.robinthoene.jav42.uidesktop.helpers.CoreApiHelper;
import com.robinthoene.jav42.uidesktop.helpers.NavigationHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * The view controller to display the login screen.
 */
public class LoginViewController {

    /**
     * The method that is called on initialization.
     */
    @FXML
    private void initialize() {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loginUser();
            }
        });
    }

    /**
     * The method to use for user login.
     */
    private void loginUser() {
        var userName = userNameInput.getText();
        var password = userPasswordInput.getText();
        var loginResult = CoreApiHelper.loginAsAdmin(userName, password);
        if (loginResult) {
            // The login was successful, display the application ui.
            NavigationHelper.navigateToScene(this.loginButton, "users-view.fxml", null, null);
        } else {
            // The login was not successful, inform the user.
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login fehlgeschlagen");
            alert.setHeaderText("Admin Login mit gegebenen Daten nicht möglich!");
            alert.showAndWait();
        }
    }

    /**
     * The button to use for login.
     */
    @FXML
    private Button loginButton;

    /**
     * The text field in which the user enters the name to login.
     */
    @FXML
    private TextField userNameInput;

    /**
     * The text field in which the user enters the password to login.
     */
    @FXML
    private PasswordField userPasswordInput;
}
