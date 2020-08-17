package controller;

import view.gui;
import javax.swing.*;

public class logoutController {

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
