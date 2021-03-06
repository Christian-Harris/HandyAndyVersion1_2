package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

import menu.LoginMenu;
import user.User;

/**
 *
 * @author Christian Harris
 */

public class HandyAndyApplication extends Application{
    
    private User currentUser = null;
    
    private static final String APP_USER = "application";
    private static final String APP_PSWD = "applicationPassword";
    private static final String CONN_STR = "jdbc:mysql://localhost:3306/handyandydb";
    private Connection DatabaseConnection = null;
    
    @Override
    public void start(Stage stage){
        try{
            DatabaseConnection = DriverManager.getConnection(CONN_STR, APP_USER, APP_PSWD);
            System.out.println("Connected to database.");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                try{
                    DatabaseConnection.close();
                    System.out.println("Disconnected from database.");
                }
                catch(SQLException ex){
                    System.out.println(ex);
                }
                Platform.exit();
                System.exit(0);
            }
        });
        
        LoginMenu loginMenu = new LoginMenu();
        Scene scene = new Scene(loginMenu, 600, 400);
        stage.setScene(scene);
        stage.setTitle("HandyAndyApplication");
        stage.show();
    }
    
    public void setCurrentUser(User user){
        this.currentUser = user;
    }
    
    public static String getApplicationUser(){
        return HandyAndyApplication.APP_USER;
    }
    
    public static String getApplicationPassword(){
        return HandyAndyApplication.APP_PSWD;
    }
    
    public static String getConnectionString(){
        return HandyAndyApplication.CONN_STR;
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
