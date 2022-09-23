package com.robinthoene.jav42.uidesktop.viewcontrollers;

import com.robinthoene.jav42.models.user.UserCreateModel;
import com.robinthoene.jav42.uidesktop.helpers.CoreApiHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Date;

/**
 * The view controller to display information about a single user.
 * Can be used to view, create or edit.
 */
public class UserDetailViewController {

    /**
     * The method that is called on initialization.
     */
    @FXML
    private void initialize() {
        actionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createNewUser();
            }
        });
    }

    /**
     * Action to create a new user.
     */
    private void createNewUser() {
        var userCreateModel = new UserCreateModel();
        userCreateModel.setUserName(userName.getText());
        userCreateModel.setFirstName(firstName.getText());
        userCreateModel.setLastName(lastName.getText());
        userCreateModel.setAdmin(false);
        var result = CoreApiHelper.createUser(userCreateModel);
        userName.setText(result.getUserName());
        firstName.setText(result.getFirstName());
        lastName.setText(result.getLastName());
        creationTimestamp.setText(result.getCreationTimestamp().toString());
        lastUpdateTimestamp.setText(result.getLastUpdatedTimestamp().toString());
    }

    /**
     * The username of the displayed user.
     */
    @FXML
    private TextField userName;

    /**
     * The first name of the displayed user.
     */
    @FXML
    private TextField firstName;

    /**
     * The last name of the displayed user.
     */
    @FXML
    private TextField lastName;

    /**
     * The creation timestamp of the displayed user.
     */
    @FXML
    private Label creationTimestamp;

    /**
     * The last update timestamp of the displayed user.
     */
    @FXML
    private Label lastUpdateTimestamp;

    /**
     * The button to perform the action.
     */
    @FXML
    private Button actionButton;
}