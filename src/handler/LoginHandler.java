package handler;

import application.HandyAndyApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import menu.LoginMenu;

/**
 *
 * @author Christian Harris
 */
public class LoginHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        try(Connection DatabaseConnection = DriverManager.getConnection(HandyAndyApplication.getConnectionString(), HandyAndyApplication.getApplicationUser(), HandyAndyApplication.getApplicationPassword())){
            System.out.println("Connected to database in LoginHandler.");
            
            LoginMenu loginMenu = (LoginMenu)(((VBox)(((Button)(e.getSource())).getParent())).getParent());
            loginMenu.setLoginMessage("Database Connected");
            
            //String username = loginMenu.getUsername();
            //String password = loginMenu.getPassword();
            
            DatabaseConnection.close();
            System.out.println("Disconnected from database in LoginHandler");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        
    }
    
}
