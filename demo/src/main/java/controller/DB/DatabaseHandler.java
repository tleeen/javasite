package controller.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    private Connection dbConnection;

    public Connection getDbConnection(){
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

    public void closeConnection(){
        if (dbConnection != null){
            try {
                dbConnection.close();
            } catch (Exception ignored) {}
        }
    }

    public String getUser(String login, String password){
        ResultSet resSet;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, login);
            prSt.setString(2, password);
            resSet = prSt.executeQuery();
            if (resSet.next()){
                closeConnection();
                return "yes";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return "no";
    }
}
