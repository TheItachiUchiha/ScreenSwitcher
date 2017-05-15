# ScreenSwitcher
Screen switch project using JavaFX FXML

Follow these instructions : https://community.oracle.com/thread/2598756

This is an implementation of the concepts discussed in the above link. 

- A main window (BorderPane), holding buttons in <top>
- Buttons should handle the app "navigation" and set the <center> item content, by loading specific fxml templates
- These templates can also act like navigators and call the mainWindow controller to change the display

So, 

Parent (main window, holding navbar) should enable navigation, and listen for children commands that could trigger navigation too.
This example is, by now, limited to 2 sub elements, but should be, later on, able to use multiple sub elements...

Meaning that the current center element of the "BorderPane" could be another borderpane, 
acting the same way with center and right items, and so on... not limited
