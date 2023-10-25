// Placeholder
import java.util.*;
import java.sql.*;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        // https://jdbc.postgresql.org/documentation/use/#connection-parameters
        // url form is a string: jdbc:postgresql://host:port/database
        // host defaults to localhost, see my notes/psql docs for more info
        // port defaults to 5432
        // database name in my case appdatabase, default would be OS username used to connect though
        //Connection db = DriverManager.getConnection(url, username, password)
    }
    // use https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Properties.html setProperty method instead of put method from https://docs.oracle.com/javase/tutorial/jdbc/basics/connecting.html for good practice.
    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/appdatabase";
        Connection conn = null;
        Properties props = new Properties();
        props.setProperty("user", "sasha");
        props.setProperty("password", "temp");
        conn = DriverManager.getConnection(url, props);
        System.out.println("Connected to database");
        return conn;
    }
}
