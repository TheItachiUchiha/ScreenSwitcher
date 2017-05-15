package screenswitcher;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {
    
    private final ObjectProperty<ViewControllerInterface> currentViewController = new SimpleObjectProperty<>();
    
    @FXML
    private BorderPane root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SubMenu.fxml"));
        Parent main = null;  
        try {
            main = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        currentViewController.set(loader.getController());
        root.setTop(main);
        ObservableValue<URL> currentView = Bindings.select(currentViewController, "selectedView");
        currentView.addListener((obs, oldView, newView) -> {
                System.out.println("CHANGELISTENER TRIGGERED!");
                if (newView == null) {
                    System.out.println("VIEW IS NULL");
                    root.setCenter(null);  
                } else {
                    System.out.println("VIEW IS NOT NULL !");
                    Parent view = null;
                    FXMLLoader viewLoader = new FXMLLoader(newView);
                    try {
                        view = viewLoader.load();
                    } catch (IOException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    root.setCenter(view);
            }  
        });  
    }       
}
