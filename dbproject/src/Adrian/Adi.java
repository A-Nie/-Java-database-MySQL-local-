package Adrian;

import java.sql.*;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class Adi {

    static String dataFromBase;
    /**
     * @param args
     */
    public static void main(String[] args) {

        String URLConnection = ("jdbc:mysql://localhost/world?user=root&password=test&useLegacyDatetimeCode=false&serverTimezone=UTC");
        //Create a simple query to the database
        String sel = "SELECT * FROM world.city";

        Connection conn = null;


        try {

            //Set the connection data
            conn = DriverManager.getConnection(URLConnection);

            //Set the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            //Run a query to the database
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sel);

            while (rs.next()) {
                displayDataFromBase(rs);
            }

            conn.close();
        }
        //Eject exceptions if there are errors with the database connection or data request error
        catch(ClassNotFoundException exception) {
            System.out.println("Problem with the controller");
        }

        catch(SQLException exception) {
            //e.printStackTrace();
            //System.out.println("Problem logging in \ n Please check: \ n username, password, database name or server IP address");
            System.out.println("SQLException: " + exception.getMessage());
            System.out.println("SQLState: " + exception.getSQLState());
            System.out.println("VendorError: " + exception.getErrorCode());
        }

    }
    static void displayDataFromBase(ResultSet rs){
        try{
            dataFromBase = rs.getString(1);
            System.out.println( dataFromBase + " ");
            dataFromBase = rs.getString(2);
            System.out.println(dataFromBase + " ");
            dataFromBase = rs.getString(3);
            System.out.println(dataFromBase + " ");
            dataFromBase = rs.getString(4);
            System.out.println( dataFromBase + " ");
            dataFromBase = rs.getString(5);
            System.out.println( dataFromBase );
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}