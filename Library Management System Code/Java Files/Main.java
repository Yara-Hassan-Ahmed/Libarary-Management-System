package LibraryManagementSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            //creation of stage scene
            // Create the FXMLLoader
            Parent root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
            // Create the Scene
            Scene scene = new Scene(root);
            // Set the Title to the Stage
            stage.setTitle("Welcome to YMY Library");
            // Set the Scene to the Stage
            stage.setScene(scene);
            // Display the Stage
            stage.show();
            //Get a handle to the stage
            //Event that consumes the action
            stage.setOnCloseRequest(event -> {
                event.consume();
                logout(stage);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Function to exit the program
    public void logout(Stage stage) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");
        //this makes all stages close and the app exit when the main stage is closed
        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You successfully logged out");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
