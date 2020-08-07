package view;

import javax.swing.*;

public class gui {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JButton button1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;

    public static void main(String[] args){
        JFrame frame = new JFrame("Patient Management System");
        frame.setContentPane(new gui().mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}





