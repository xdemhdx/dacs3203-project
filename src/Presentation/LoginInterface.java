package Presentation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Business.UserAuthentication;

public class LoginInterface {
    private Label errorMessage;
    private Label successMessage;
    private int role;

    public VBox createLoginPane() {
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        HBox usernameBox = new HBox(usernameLabel, usernameField);
        usernameBox.setSpacing(10);
        usernameBox.setPrefWidth(200); // Set preferred width
        usernameBox.setAlignment(Pos.CENTER);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        HBox passwordBox = new HBox(passwordLabel, passwordField);
        passwordBox.setSpacing(10);
        passwordBox.setPrefWidth(200); // Set preferred width
        passwordBox.setAlignment(Pos.BASELINE_CENTER);
        errorMessage = new Label();
        errorMessage.setStyle("-fx-text-fill: red;");
        successMessage = new Label();
        successMessage.setStyle("-fx-text-fill: green;");
        Button loginButton = new Button("Login");


        loginButton.setOnAction(e -> {
            // Perform login action
            // For example, validate username and password
            // If successful, proceed to main application, else show error message
            // For simplicity, we just print the username and password for now
            boolean result = UserAuthentication.checkLogin(usernameField.getText(),passwordField.getText());
            if (!result) {
                successMessage.setText("");
                errorMessage.setText("Incorrect Username or Password");               
            } else {
                System.out.println("Success");
                role = UserAuthentication.checkRole(usernameField.getText());
                switch (role) {
                    case 0:
                        System.out.println("Admin Interface");
                        break;
                
                    case 1:
                        System.out.println("Instructor Interface");
                        break;
                    case 2:
                        System.out.println("Student Interface");
                        break;
                    default:
                        break;
                    
                }
            }
        });

        VBox loginPane = new VBox(10);
        loginPane.getChildren().addAll(usernameBox, passwordBox, loginButton,errorMessage,successMessage);

        // Center align the login button
        loginPane.setAlignment(Pos.CENTER);

        return loginPane;
    }
}
