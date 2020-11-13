package handler;

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
        String username = ((LoginMenu)(((VBox)(((Button)(e.getSource())).getParent())).getParent())).getUsername();
        String password = ((LoginMenu)(((VBox)(((Button)(e.getSource())).getParent())).getParent())).getPassword();
    }
    
}
