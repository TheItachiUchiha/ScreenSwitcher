package screenswitcher;

import javafx.beans.property.ReadOnlyObjectProperty;

import java.net.URL;

public interface ViewControllerInterface {

    ReadOnlyObjectProperty<URL> selectedViewProperty();
    
    URL getSelectedView() ;
}
