package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnnection {
  public   Connection database;
    public Connection getDatabase() {
        String dbname = "db";
        String dbuser = "root";
        String dbpass = "123456789";
        String url = "jdbc:mysql://localhost/" + dbname;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            database = DriverManager.getConnection(url,dbuser,dbpass); // database connection here
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return database;
    }
}
