package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.loginRegistrationController;

public class gui {
    private JPanel mainPanel;
    private JTabbedPane tabPanel;
    private JButton btnReg;
    private JTextField txtForename;
    private JTextField txtUserType;
    private JTextField txtSurname;
    private JTextField txtGender;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtCounty;
    private JTextField txtPostcode;
    private JTextField txtTel;
    private JTextField txtEmail;
    private JTextField txtPassword;
    private JTextField txtConfPassword;
    private JTextField txtUserIDLogin;
    private JButton btnSignIn;
    private JTextField txtPassLogin;


    public gui() {
        btnReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //if(txtPassword.getText() == txtConfPassword.getText()){
                    String type = txtUserType.getText();
                    String forename = txtForename.getText();
                    String surname = txtSurname.getText();
                    String gender = txtGender.getText();
                    String address = txtAddress.getText();
                    String city = txtCity.getText();
                    String county = txtCounty.getText();
                    String postcode = txtPostcode.getText();
                    String password = txtPassword.getText();
                    loginRegistrationController.registerUser(type, password, forename, surname, address, city, county, postcode, gender);
                //}
            }
        });

        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = txtUserIDLogin.getText();
                String password = txtPassLogin.getText();
                loginRegistrationController.logIn(userID, password);
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





