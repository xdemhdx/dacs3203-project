package Business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Data.DataAccessLayer;

public class UserAuthentication {

    public static int checkRole(String username){
        String sql = "SELECT Role FROM users WHERE username = ?";
        try{
            Connection connection = DataAccessLayer.establishConnection();
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                  return Integer.parseInt(resultSet.getString("Role"));
            }
            DataAccessLayer.connectionClose(connection, null);

        }catch(SQLException e){
            e.getMessage();
        }

        return 0;
    }

    public static boolean checkLogin(String username, String password) {
        String hashedPassword = PasswordHandler.hashPassword(password);
        if (hashedPassword == null) {
            return false; // Hashing failed
        }

        // Execute SQL query to check if username and hashed password match
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND PasswordHash = ?";
        try{
            Connection connection = DataAccessLayer.establishConnection();
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Returns true if username and password match
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
