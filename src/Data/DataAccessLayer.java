package Data;
import java.sql.*;

import com.mysql.cj.xdevapi.Statement;

public class DataAccessLayer {
    private static String url ="jdbc:mysql://localhost:3306/education";
    private static String appUsername ="root";
    private static String appPassword ="";
    
    public static Connection establishConnection(){
    Connection con = null;
        try{
                con = DriverManager.getConnection(url, appUsername, appPassword);
                System.out.println("Connection Successful");
        }catch(SQLException e){
                System.out.println(e.getMessage());
        }
        return con;
    }

    public static void connectionClose(Connection con ,Statement stmt){
        try{
            con.close();
            System.out.println("Connection is closed");
        }catch(SQLException e){
            e.getMessage();
        }

    }

}
