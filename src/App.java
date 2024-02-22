import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Business.BusinessLayer;
import Data.DataAccessLayer;
import Presentation.PresentationLayer;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a Label component
        Label helloWorldLabel = new Label(BusinessLayer.performBusinessLogic());

        // Create a layout (StackPane) and add the Label to it
        StackPane root = new StackPane();
        root.getChildren().add(helloWorldLabel);

        // Create a Scene specifying the root layout and its dimensions
        Scene scene = new Scene(root, 320, 240);

        // Set the title of the Stage (window)
        primaryStage.setTitle("JavaFX Hello World Example");
        // Set the Scene of the Stage
        primaryStage.setScene(scene);
        // Display the Stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
