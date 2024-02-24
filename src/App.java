// File: App.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import Presentation.PresentationLayer;
import java.sql.*;

import Business.PasswordHandler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Data.DataAccessLayer;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Instantiate the PresentationLayer
        PresentationLayer presentation = new PresentationLayer();

        // Create buttons
        Button btnUser1 = new Button("User 1");
        btnUser1.setOnAction(e -> System.out.println(presentation.getUser1()));

        Button btnUser2 = new Button("User 2");
        btnUser2.setOnAction(e -> System.out.println(presentation.getUser2()));

        Button btnUser3 = new Button("User 3");
        btnUser3.setOnAction(e -> System.out.println(presentation.getUser3()));

        // Add buttons to layout
        HBox hbox = new HBox(10, btnUser1, btnUser2, btnUser3); // 10 is the spacing between buttons
        String sql = "Select * from users;";
        // Set up the scene and stage
        Connection con = DataAccessLayer.establishConnection();
        String password = "";
        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                password = result.getString("PasswordHash");
                System.out.println(result.getString("Email"));
                
            }
            DataAccessLayer.connectionClose(con, null);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        boolean passwordMatches = PasswordHandler.verifyPassword("12class34", password);
        System.out.println("Password matches: " + passwordMatches);
        
        Scene scene = new Scene(hbox, 300, 100);
        primaryStage.setTitle("User Selection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
