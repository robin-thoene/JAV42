package com.robinthoene.jav42.uidesktop.viewcontrollers;

import com.robinthoene.jav42.models.user.UserReadModel;
import com.robinthoene.jav42.uidesktop.helpers.CoreApiHelper;
import com.robinthoene.jav42.uidesktop.helpers.NavigationHelper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

/**
 * The view controller to display the table of all users.
 */
public class UsersViewController {

    /**
     * The method that is called on initialization.
     */
    @FXML
    private void initialize() {
        // Add the action to the new user button.
        addNewUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                openUserCreation();
            }
        });
        // Init the table column cell value factories.
        userName.setCellValueFactory(new PropertyValueFactory<UserReadModel, String>("userName"));
        firstName.setCellValueFactory(new PropertyValueFactory<UserReadModel, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<UserReadModel, String>("lastName"));
        lastUpdatedTimestamp.setCellValueFactory(new PropertyValueFactory<UserReadModel, Date>("lastUpdatedTimestamp"));
        creationTimestamp.setCellValueFactory(new PropertyValueFactory<UserReadModel, Date>("creationTimestamp"));
        // Get all available users.
        var availableUsers = CoreApiHelper.getAllUsers();
        // Convert to observable list.
        var observableUsersList = FXCollections.observableArrayList(availableUsers);
        // Set initial user data.
        userTable.getItems().setAll(observableUsersList);
    }

    /**
     * Open the user creation.
     */
    private void openUserCreation() {
        NavigationHelper.navigateToScene(addNewUserButton, "user-detail-view.fxml", null, null);
    }

    /**
     * The button to add a new user.
     */
    @FXML
    private Button addNewUserButton;

    /**
     * The reference to the table that displays the users.
     */
    @FXML
    private TableView<UserReadModel> userTable;

    /**
     * The username column.
     */
    @FXML
    private TableColumn<UserReadModel, String> userName;

    /**
     * The first name column.
     */
    @FXML
    private TableColumn<UserReadModel, String> firstName;

    /**
     * The last name column.
     */
    @FXML
    private TableColumn<UserReadModel, String> lastName;

    /**
     * The creation date column.
     */
    @FXML
    private TableColumn<UserReadModel, Date> creationTimestamp;

    /**
     * The last update date column.
     */
    @FXML
    private TableColumn<UserReadModel, Date> lastUpdatedTimestamp;
}