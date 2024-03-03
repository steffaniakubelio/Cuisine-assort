package com.example.recipemanagement;
        import java.sql.Driver;
        import java.lang.Class;
        import java.sql.Connection;
        import java.sql.DriverManager;
public class dbconnection {
    public  Connection databaselink;
    public  Connection getConnection() {
        String databaseName="recipemanage";
        String databaseUser ="root";
        String databasePassword ="steffy2306@";
        String url= "jdbc:mysql://localhost/recipemanage" ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink= DriverManager.getConnection(url,databaseUser,databasePassword);
            System.out.println("DB connection success");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return databaselink;
    }
}