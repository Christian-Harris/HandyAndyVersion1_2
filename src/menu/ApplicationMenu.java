package menu;

import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Christian Harris
 */
public class ApplicationMenu extends BorderPane{
    MenuBar menuBar;
    Menu fileMenu;
    MenuItem openFile;
    
    public ApplicationMenu(){
        menuBar = new MenuBar();
        fileMenu = new Menu("File");
        openFile = new MenuItem("Open File");
        
        fileMenu.getItems().add(openFile);
        menuBar.getMenus().add(fileMenu);
        
        this.setTop(menuBar);
    }
}
