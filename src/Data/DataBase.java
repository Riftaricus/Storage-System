package Data;

import Item.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataBase {
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
            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
            String user = "root";
            String password = "root";
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

        ArrayList<Item> items = new ArrayList<>(); 

        // TODO get info arraylist of items from database

        for (Item item : items){
            ItemController.createItem(item.getName(), item.getType());
        }

        return resolved;
    }

    public static boolean updateDatabase() {
        boolean resolved = true;
        ArrayList<Item> itemArrayList = ItemController.getItemList();

        for (Item i : itemArrayList) {
            String name = i.getName();
            String type = i.getType();
            int id = i.getId();

            LocalDate startDate = i.getLendStartDate();
            LocalDate endDate = i.getLendEndDate();

            String borrowerName = i.getBorrowerName();

            // TODO loading to database here
        }
        return resolved;
    }

}
