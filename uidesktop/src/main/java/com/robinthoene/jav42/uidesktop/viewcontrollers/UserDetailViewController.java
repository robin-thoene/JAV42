package com.robinthoene.jav42.uidesktop.viewcontrollers;

import com.robinthoene.jav42.common.models.user.UserCreateModel;
import com.robinthoene.jav42.common.models.user.UserReadModel;
import com.robinthoene.jav42.common.models.user.UserUpdateModel;
import com.robinthoene.jav42.uidesktop.enumerations.UserDetailViewMode;
import com.robinthoene.jav42.uidesktop.helpers.CoreApiHelper;
import com.robinthoene.jav42.uidesktop.helpers.NavigationHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * The view controller to display information about a single user.
 * Can be used to view, create or edit.
 */
public class UserDetailViewController {

    public void initData(UserReadModel user) {
        // Set mode to edit.
        mode = UserDetailViewMode.EDIT;
        userName.setText(user.getUserName());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        isAdmin.setSelected(user.isAdmin());
        creationTimestamp.setText(user.getCreationTimestamp().toString());
        lastUpdateTimestamp.setText(user.getLastUpdatedTimestamp().toString());
        // Store the id of the user.
        userId = user.getId();
        // Disable non editable controls.
        userName.setDisable(true);
        var me = CoreApiHelper.getMe();
        if (user.getUserName().equals(me)) {
            isAdmin.setDisable(true);
        }
    }

    /**
     * The method that is called on initialization.
     */
    @FXML
    private void initialize() {
        activateEdit.setVisible(false);
        activateEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (mode != UserDetailViewMode.EDIT) {
                    mode = UserDetailViewMode.EDIT;
                }
                userName.setDisable(true);
                firstName.setDisable(false);
                lastName.setDisable(false);
                var me = CoreApiHelper.getMe();
                if (!userName.getText().equals(me)) {
                    isAdmin.setDisable(false);
                }
                activateEdit.setVisible(false);
                saveButton.setVisible(true);
                initialPassword.setVisible(false);
                initialPasswordLabel.setVisible(false);
            }
        });
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switch (mode) {
                    case EDIT:
                        updateUser();
                        setToViewMode();
                        break;
                    case CREATE:
                        createNewUser();
                        setToViewMode();
                        break;
                    default:
                        break;
                }

            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                leave();
            }
        });
        initialPassword.setVisible(false);
        initialPasswordLabel.setVisible(false);
    }

    /**
     * Navigate back and reset states.
     */
    private void leave() {
        // Set mode back to create.
        mode = UserDetailViewMode.CREATE;
        // Enable all controls.
        isAdmin.setDisable(false);
        userName.setDisable(false);
        // Reset user id.
        userId = null;
        // Reset buttons.
        activateEdit.setVisible(false);
        // Leave view.
        NavigationHelper.navigateToScene(saveButton, "users-view.fxml", null, null);
    }

    private void setToViewMode() {
        saveButton.setVisible(false);
        mode = UserDetailViewMode.VIEW;
        activateEdit.setVisible(true);
        userName.setDisable(true);
        firstName.setDisable(true);
        lastName.setDisable(true);
        isAdmin.setDisable(true);
    }

    /**
     * Action to create a new user.
     */
    private void createNewUser() {
        if (userName.getText().equals("") || firstName.getText().equals("") || lastName.getText().equals("")) {
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erstellung nicht möglich");
            alert.setHeaderText("Nicht alle Pflichtfelder wurden ausgefüllt.");
            alert.showAndWait();
            return;
        }
        var userCreateModel = new UserCreateModel();
        userCreateModel.setUserName(userName.getText());
        userCreateModel.setFirstName(firstName.getText());
        userCreateModel.setLastName(lastName.getText());
        userCreateModel.setAdmin(isAdmin.isSelected());
        try {
            var result = CoreApiHelper.createUser(userCreateModel);
            userName.setText(result.getUserName());
            firstName.setText(result.getFirstName());
            lastName.setText(result.getLastName());
            creationTimestamp.setText(result.getCreationTimestamp().toString());
            lastUpdateTimestamp.setText(result.getLastUpdatedTimestamp().toString());
            isAdmin.setSelected(result.isAdmin());
            initialPassword.setText(result.getPassword());
            userId = result.getId();
            initialPassword.setVisible(true);
            initialPasswordLabel.setVisible(true);
        } catch (Exception ex) {
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erstellung fehlgeschlagen");
            alert.setHeaderText("Ein unerwarteter Fehler ist aufgetreten.");
            alert.showAndWait();
        }
    }

    /**
     * Action to update an existing user.
     */
    private void updateUser() {
        if (userName.getText().equals("") || firstName.getText().equals("") || lastName.getText().equals("")) {
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Aktualisierung nich möglich");
            alert.setHeaderText("Nicht alle Pflichtfelder wurden ausgefüllt.");
            alert.showAndWait();
            return;
        }
        var userUpdateModel = new UserUpdateModel();
        userUpdateModel.setId(userId);
        userUpdateModel.setAdmin(isAdmin.isSelected());
        userUpdateModel.setFirstName(firstName.getText());
        userUpdateModel.setLastName(lastName.getText());
        try {

            var result = CoreApiHelper.updateUser(userUpdateModel);
            userName.setText(result.getUserName());
            firstName.setText(result.getFirstName());
            lastName.setText(result.getLastName());
            creationTimestamp.setText(result.getCreationTimestamp().toString());
            lastUpdateTimestamp.setText(result.getLastUpdatedTimestamp().toString());
            isAdmin.setSelected(result.isAdmin());
        } catch (Exception ex) {
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Aktualisierung fehlgeschlagen");
            alert.setHeaderText("Ein unerwarteter Fehler ist aufgetreten.");
            alert.showAndWait();
        }
    }

    /**
     * The current mode of the view.
     */
    private UserDetailViewMode mode = UserDetailViewMode.CREATE;

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
     * The button to perform the save action.
     */
    @FXML
    private Button saveButton;

    /**
     * Control to set whether the user is an admin or not.
     */
    @FXML
    private CheckBox isAdmin;

    /**
     * The unique database identifier of the user.
     */
    private Long userId = null;

    /**
     * The button to leave teh view.
     */
    @FXML
    private Button backButton;

    /**
     * The button to activate edit mode.
     */
    @FXML
    private Button activateEdit;

    /**
     * The label to display the initial password for new created users.
     */
    @FXML
    private TextField initialPassword;

    /**
     * The label above the initial password for new created users.
     */
    @FXML
    private Label initialPasswordLabel;
}