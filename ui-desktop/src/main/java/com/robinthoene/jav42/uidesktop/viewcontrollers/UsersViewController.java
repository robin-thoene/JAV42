package com.robinthoene.jav42.uidesktop.viewcontrollers;

import com.robinthoene.jav42.models.user.UserReadModel;
import com.robinthoene.jav42.uidesktop.helpers.CoreApiHelper;
import com.robinthoene.jav42.uidesktop.helpers.NavigationHelper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
        isAdmin.setCellValueFactory(cellData -> {
            boolean isAdmin = cellData.getValue().isAdmin();
            String displayValue = isAdmin ? "Admin" : "Nutzer";
            return new ReadOnlyStringWrapper(displayValue);
        });


        // Init the action column.
        actions.setCellFactory(new Callback<TableColumn<UserReadModel, Void>, TableCell<UserReadModel, Void>>() {
            @Override
            public TableCell<UserReadModel, Void> call(TableColumn<UserReadModel, Void> param) {
                var cell = new TableCell<UserReadModel, Void>() {
                    private final Button deleteButton = new Button("Löschen");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            var data = getTableView().getItems().get(getIndex());
                            var me = CoreApiHelper.getMe();
                            if (data.getUserName().equals(me)) {
                                // Inform the user that it is not allowed as admin to delete yourself at the moment.
                                var alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Löschung nicht möglich");
                                alert.setHeaderText("Es ist momentan nicht vorgesehen, dass sich ein Admin selbst löscht.");
                                alert.showAndWait();
                                return;
                            }
                            var wasDeletionSuccessful = deleteUser(data.getId());
                            if (wasDeletionSuccessful) {
                                // Remove the user from the table.
                                getTableView().getItems().remove(data);
                            } else {
                                // TODO: Display error message.
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(deleteButton);
                        }
                    }
                };
                return cell;
            }
        });
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
     * Delete a user.
     *
     * @param userId The unique identifier of the user.
     * @return True if the deletion was successful, false if not.
     */
    private boolean deleteUser(long userId) {
        var result = CoreApiHelper.deleteUser(userId);
        return result;
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

    /**
     * The column that offers actions.
     */
    @FXML
    private TableColumn<UserReadModel, Void> actions;

    /**
     * Display whether the user is an admin or not.
     */
    @FXML
    private TableColumn<UserReadModel, String> isAdmin;
}