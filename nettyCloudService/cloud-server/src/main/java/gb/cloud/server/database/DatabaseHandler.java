package gb.cloud.server.database;

import java.sql.*;

public class DatabaseHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://localhost:3306/cloud";
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection= DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }
    public void regUser(User user){
        String insert = "INSERT INTO "+ Constant.USER_TABLE + "(" + Constant.USERS_NAME + " "+ Constant.USERS_PASSWORD + ")"+ "VALUES (?,?)";


        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getUsername());
            prSt.setString(2,user.getPassword());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public ResultSet getUser(User user){
        ResultSet rs = null;
        String select = "SELECT * FROM "+ Constant.USER_TABLE + " WHERE "+ Constant.USERS_NAME + "=? AND " + Constant.USERS_PASSWORD+"=?";

        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getUsername());
            prSt.setString(2,user.getPassword());
            prSt.executeQuery();
            rs= prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
