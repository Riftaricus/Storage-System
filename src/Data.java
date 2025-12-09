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
            String url = "";
            String user = "";
            String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            databaseConnection = con;

            databaseLoaded = true;
        } catch (SQLException e) {
            e.printStackTrace();
            databaseLoaded = false;
        }

        return databaseLoaded;

    }

    public static boolean triggerSelectStatement(String query) {
        if (!databaseLoaded)
            return false;

        try (Statement stmt = databaseConnection.createStatement()) {
            boolean hasResultSet = stmt.execute(query);
            if (hasResultSet) {
                try (ResultSet rs = stmt.getResultSet()) {
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.println(rs.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean triggerEditStatement(String query) {
        if (!databaseLoaded)
            return false;

        try (Statement stmt = databaseConnection.createStatement()) {
            boolean hasResultSet = stmt.execute(query);
            if (hasResultSet) {
                try (ResultSet rs = stmt.getResultSet()) {
                    int affectedRows = stmt.executeUpdate(query);
                    System.out.println(affectedRows);
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateItems() {
        boolean resolved = true;

        if (!databaseLoaded)
            return false;

        // Loading from database here

        return resolved;
    }

}
