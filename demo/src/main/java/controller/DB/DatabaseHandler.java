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

    public Boolean getUser(String login, String password){
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
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return false;
    }

    public void InsertProduct(String id_user, String product_poz, String product_title, String product_price){
        String insert = "INSERT INTO " + Const.USER_PRODUCT_TABLE + "(" +
                Const.USER_PRODUCT_ID_USER + "," + Const.USER_PRODUCT_POZ + "," + Const.USER_PRODUCT_TITLE + "," + Const.USER_PRODUCT_PRICE +")" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, id_user);
            prSt.setString(2, product_poz);
            prSt.setString(1, product_title);
            prSt.setString(2, product_price);
            prSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
    }
}
