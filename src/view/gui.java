package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Serialisation.setUpData;
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
    private JTextField txtUserIDLogin;
    private JButton btnSignIn;
    private JPasswordField txtPassLogin;
    private JPanel signInPanel;
    private JPanel registerPanel;
    private JPanel logOutPanel;
    private JPanel appointmentsPanel;
    private JPanel doctorsPanel;
    private JPanel medicalhistoryPanel;
    private JComboBox dropUserType;
    private JPasswordField regPassword;
    private JPasswordField regConfPassword;



    private JPanel accountManagementPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton updatePatientButton;
    private JList secretaryAccManagement;
    private JTextField textField8;

    public gui() {
        //add combo box items
        dropUserType.addItem("Patient");
        dropUserType.addItem("Administrator");

        btnReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = (String) dropUserType.getSelectedItem();
                String forename = txtForename.getText();
                String surname = txtSurname.getText();
                String gender = txtGender.getText();
                String address = txtAddress.getText();
                String city = txtCity.getText();
                String county = txtCounty.getText();
                String postcode = txtPostcode.getText();
                char[] password = regPassword.getPassword();
                loginRegistrationController.registerUser(type, password, forename, surname, address, city, county, postcode, gender);
                //}
            }
        });

        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = txtUserIDLogin.getText();
                char[] password = txtPassLogin.getPassword();
                loginRegistrationController.logIn(userID, password, gui);
            }
        });
    }

    public static void main(String[] args) {
        gui = new gui();
        JFrame frame = new JFrame("Patient Management System");
        frame.setContentPane(gui.getTabs());
        frame.setSize(1700, 1000);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        loginRegistrationController.loadInitialTabs(gui);

        //setUpData.addStartUpData();

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

    public JComboBox getDropUserType() {
        return dropUserType;
    }

    public void setDropUserType(JComboBox dropUserType) {
        this.dropUserType = dropUserType;
    }

    public JPanel getAccountManagementPanel() {
        return accountManagementPanel;
    }

    public void setAccountManagementPanel(JPanel accountManagementPanel) {
        this.accountManagementPanel = accountManagementPanel;
    }
}





