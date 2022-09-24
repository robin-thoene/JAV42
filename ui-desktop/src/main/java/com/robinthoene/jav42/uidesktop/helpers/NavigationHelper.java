package com.robinthoene.jav42.uidesktop.helpers;

import com.robinthoene.jav42.models.user.UserReadModel;
import com.robinthoene.jav42.uidesktop.Application;
import com.robinthoene.jav42.uidesktop.viewcontrollers.UserDetailViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Helper to navigate inside the application.
 */
public final class NavigationHelper {

    /**
     * Navigate to a specified scene.
     *
     * @param node      The node to use to retrieve the current stage.
     * @param sceneName The name of the scene to open.
     * @param width     The requested window with.
     * @param height    The requested window height.
     */
    public static void navigateToScene(Node node, String sceneName, Optional<Double> width, Optional<Double> height) {
        // Get the stage based of the provided node.
        var stage = (Stage) node.getScene().getWindow();
        // Load the desired scene.
        var fxmlLoader = new FXMLLoader(Application.class.getResource(sceneName));
        // Get the desired height and width.
        var widthToUse = width == null ? defaultWindowWidth : width;
        var heightToUse = height == null ? defaultWindowHeight : height;
        try {
            // Try to navigate to the scene.
            stage.setScene(new Scene(fxmlLoader.load(), (double) widthToUse, (double) heightToUse));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Navigate to the user detail view.
     *
     * @param node      The node to use to retrieve the current stage.
     * @param sceneName The name of the scene to open.
     * @param user      The user to display.
     * @param width     The requested window with.
     * @param height    The requested window height.
     */
    public static void navigateToUserDetailView(Node node, String sceneName, UserReadModel user, Optional<Double> width, Optional<Double> height) {
        // Get the stage based of the provided node.
        var stage = (Stage) node.getScene().getWindow();
        // Load the desired scene.
        var fxmlLoader = new FXMLLoader(Application.class.getResource(sceneName));
        // Get the desired height and width.
        var widthToUse = width == null ? defaultWindowWidth : width;
        var heightToUse = height == null ? defaultWindowHeight : height;
        if (user != null) {
            // Pass the user as param.
            var viewController = (UserDetailViewController) fxmlLoader.getController();
            viewController.initData(user);
        }
        try {
            // Try to navigate to the scene.
            stage.setScene(new Scene(fxmlLoader.load(), (double) widthToUse, (double) heightToUse));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The default width of the application.
     */
    private static Double defaultWindowWidth = 1200.0;

    /**
     * The default height of the application.
     */
    private static Double defaultWindowHeight = 600.0;
}
