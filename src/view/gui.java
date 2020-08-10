package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
    private JPanel mainPanel;
    private JTabbedPane tabPanel;
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

    public gui() {
        btnReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Patient Management System");
        frame.setContentPane(new gui().mainPanel);
        frame.setSize(1700, 1000);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}





