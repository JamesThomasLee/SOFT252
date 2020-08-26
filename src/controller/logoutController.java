package controller;

import view.gui;
import javax.swing.*;

/**
 * A controller to handle a user logging out.
 */
public class logoutController {

    /**
     * Logging out function to log out a user.
     * @param gui - gui
     */
    public static void logoutUser(gui gui){
        int confirm = JOptionPane.YES_NO_OPTION;
        int outcome = JOptionPane.showConfirmDialog(null, "Are you sure you would like to log out?", "Are you sure?", confirm);
        if(outcome == JOptionPane.YES_OPTION){
            gui.getTabs().removeAll();
            gui.getTabs().add(gui.getSignInPanel());
            gui.getTabs().setTitleAt(0, "Sign In");
            gui.getTabs().add(gui.getRegisterPanel());
            gui.getTabs().setTitleAt(1, "Register");
        }
    }
}
