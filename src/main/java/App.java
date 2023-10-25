// Placeholder
import java.util.*;
import java.sql.*;

public class App {
    public static void main(String[] args) {
        // by default gradle does not work with interactive command line stdin so,
        // instead, ask for command-line argument for testing purposes 
        if (args.length < 1) {
            System.err.println("Please provide the database password as a command-line argument.");
            System.exit(1);
        }

        String password = args[0];        
        try {
            Connection connection = new App().getConnection(password);
            // Test database operations, confirm successful operations in psql
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        // https://jdbc.postgresql.org/documentation/use/#connection-parameters
        // url form is a string: jdbc:postgresql://host:port/database
        // host defaults to localhost, see my notes/psql docs for more info
        // port defaults to 5432
        // database name in my case appdatabase, default would be OS username used to connect though
        //Connection db = DriverManager.getConnection(url, username, password)
    }
    // use https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Properties.html setProperty method instead of put method from https://docs.oracle.com/javase/tutorial/jdbc/basics/connecting.html for good practice.
    public Connection getConnection(String password) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/appdatabase";
        Connection conn = null;
        Properties props = new Properties();
        props.setProperty("user", "sasha");
        props.setProperty("password", password);
        conn = DriverManager.getConnection(url, props);
        System.out.println("Connected to database");
        return conn;
    }
}
