import java.sql.*;

public class Data {
    public static boolean databaseLoaded = false;

    public static Connection databaseConnection;

    public static boolean closeDatabase() {
        boolean resolved = true;
        try {
            if (databaseConnection != null && !databaseConnection.isClosed())
                databaseConnection.close();

        } catch (SQLException e) {
            resolved = false;
            e.printStackTrace();
        }
        databaseLoaded = false;

        return resolved;
    }

    public static boolean loadDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "";
            String user = "";
            String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            databaseConnection = con;

            databaseLoaded = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            databaseLoaded = false;
        } catch (SQLException e) {
            e.printStackTrace();
            databaseLoaded = false;
        }

        return databaseLoaded;

    }

    public static boolean executeUpdate(String query) {
        boolean executedStatementSuccesfully = true;

        if (databaseLoaded) {
            try (Statement statement = databaseConnection.createStatement()) {
                ResultSet rs = statement.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
                executedStatementSuccesfully = false;
            }
        } else
            executedStatementSuccesfully = false;

        return executedStatementSuccesfully;
    }

}
