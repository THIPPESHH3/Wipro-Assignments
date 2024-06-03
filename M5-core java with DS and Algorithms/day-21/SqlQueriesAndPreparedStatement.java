Day_21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SqlQueriesAndPreparedStatement {

    static final String URL = "jdbc:mysql://localhost:3306/training";
    static final String USERNAME = "root";
    static final String PASSWORD = "Asdfghjkl1234@";

    static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS User (user_id INT PRIMARY KEY, password INT)";
    static final String INSERT_USER_QUERY = "INSERT INTO User (user_id, password) VALUES (?, ?)";
    static final String SELECT_USER_QUERY = "SELECT * FROM User WHERE user_id = ? AND password = ?";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            createTable(connection);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter User ID:");
            int userId = scanner.nextInt();
            System.out.println("Enter Password:");
            String password = scanner.next();

            
            int hashedPassword = password.hashCode();

            insertUser(connection, userId, hashedPassword);

            boolean isAuthenticated = authenticateUser(connection, userId, hashedPassword);
            if (isAuthenticated) {
                System.out.println("User authenticated. Access granted!");
            } else {
                System.out.println("Invalid User ID or Password. Access denied!");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
        preparedStatement.executeUpdate();
        System.out.println("User table created (if not exists).");
    }

    private static void insertUser(Connection connection, int userId, int hashedPassword) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY);
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, hashedPassword);
        preparedStatement.executeUpdate();
        System.out.println("User inserted into database.");
    }
    

    private static boolean authenticateUser(Connection connection, int userId, int hashedPassword) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_QUERY);
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, hashedPassword);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
  /*  private static boolean authenticateUser(Connection connection, int userId, int hashedPassword) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM User WHERE user_id = " + userId + " AND password = " + hashedPassword;
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet.next();
    }
   */
}

