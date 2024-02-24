import Presentation.LoginInterface;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;
    private Scene initialScene;

    @Override
    public void start(Stage primaryStage) {
                this.primaryStage = primaryStage;

        // Title label
        Label titleLabel = new Label("UDST Education Learning System");
        titleLabel.setStyle("-fx-font-size: 24px;");

        // Initial scene with title and a button to show the login interface
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> showLoginInterface());

        VBox root = new VBox(20);
        root.getChildren().addAll(titleLabel, loginButton);
        root.setAlignment(Pos.CENTER);
        initialScene = new Scene(root, 600, 400);
        primaryStage.setScene(initialScene);
        primaryStage.setTitle("Educatoion App");
        primaryStage.show();
    }

    private void showLoginInterface() {
        // Load the login interface and display it
        LoginInterface loginUI = new LoginInterface();
        Scene loginScene = new Scene(loginUI.createLoginPane(), 600, 400);
        primaryStage.setScene(loginScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
