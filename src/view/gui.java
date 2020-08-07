package view;

import javax.swing.*;

public class gui {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JButton btnReg;
    private JTextField txtForename;
    private JTextField txtUserType;
    private JTextField txtSurname;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtCounty;
    private JTextField txtPostcode;
    private JTextField txtTel;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JPasswordField txtConfPassword;
    private JTextField txtUsername;
    private JButton btnSignIn;

    public static void main(String[] args){
        JFrame frame = new JFrame("Patient Management System");
        frame.setContentPane(new gui().mainPanel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}





