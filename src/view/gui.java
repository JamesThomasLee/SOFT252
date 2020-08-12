package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.loginRegistrationController;

public class gui {
    private static view.gui gui;
    private JPanel mainPanel;
    private JTabbedPane tabs;
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
    private JPanel signInPanel;
    private JPanel registerPanel;
    private JPanel logOutPanel;
    private JPanel appointmentsPanel;
    private JPanel doctorsPanel;
    private JPanel medicalhistoryPanel;


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
                loginRegistrationController.logIn(userID, password, gui);
            }
        });
    }

    public static void main(String[] args){
        gui = new gui();
        JFrame frame = new JFrame("Patient Management System");
        frame.setContentPane(gui.getTabs());
        frame.setSize(1700, 1000);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        loginRegistrationController.loadInitialTabs(gui);

        frame.setVisible(true);

    }

    public static view.gui getGui() {
        return gui;
    }

    public JTabbedPane getTabs() {
        return tabs;
    }

    public JPanel getSignInPanel() {
        return signInPanel;
    }

    public void setSignInPanel(JPanel signInPanel) {
        this.signInPanel = signInPanel;
    }

    public JPanel getRegisterPanel() {
        return registerPanel;
    }

    public void setRegisterPanel(JPanel registerPanel) {
        this.registerPanel = registerPanel;
    }

    public JPanel getAppointmentsPanel() {
        return appointmentsPanel;
    }

    public void setAppointmentsPanel(JPanel appointmentsPanel) {
        this.appointmentsPanel = appointmentsPanel;
    }

    public JPanel getDoctorsPanel() {
        return doctorsPanel;
    }

    public void setDoctorsPanel(JPanel doctorsPanel) {
        this.doctorsPanel = doctorsPanel;
    }

    public JPanel getMedicalhistoryPanel() {
        return medicalhistoryPanel;
    }

    public void setMedicalhistoryPanel(JPanel medicalhistoryPanel) {
        this.medicalhistoryPanel = medicalhistoryPanel;
    }

    public JPanel getlogOutPanel() {
        return logOutPanel;
    }

    public void setlogOutPanel(JPanel logOutPanel) {
        this.logOutPanel = logOutPanel;
    }
}





