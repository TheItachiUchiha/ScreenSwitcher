package screenswitcher;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;

import java.net.URL;

public class SubMenuController implements ViewControllerInterface {

    private final ReadOnlyObjectWrapper<URL> selectedView = new ReadOnlyObjectWrapper<>(this, "selectedView", null);

    @Override
    public ReadOnlyObjectProperty<URL> selectedViewProperty() {
        return selectedView.getReadOnlyProperty();
    }

    @Override
    public URL getSelectedView() {
        return selectedView.get();
    }

    @FXML
    public void goPaneOne(){
        selectedView.set(getClass().getResource("PaneOne.fxml"));
    }

    @FXML
    public void goPaneTwo(){
        selectedView.set(getClass().getResource("PaneTwo.fxml"));
    }
}
