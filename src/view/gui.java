package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import Serialisation.setUpData;
import controller.*;
import users.patient;

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
    private JTextField ptntFirstName;
    private JTextField ptntSurname;
    private JTextField ptntGender;
    private JTextField ptntAddress;
    private JTextField ptntCity;
    private JTextField ptntCounty;
    private JTextField ptntPostcode;
    private JButton updatePatientButton;
    private JTextField ptntAuthorised;
    private JList SecAccManagement;
    private JButton btnLogout;
    private JTextField txtAuthoriseUserID;
    private JButton btnAuthorise;
    private JPanel authorisePanel;
    private JTextField txtDeletePatient;
    private JButton btnDeletePatient;
    private JPanel patientsPanel;
    private JList appointmentsList;
    private JComboBox patientCombo;
    private JTextField ptFirstName;
    private JTextField ptSurname;
    private JTextField ptGender;
    private JTextField ptAddress;
    private JTextField ptCity;
    private JTextField ptCounty;
    private JTextField ptPostcode;
    private JComboBox patientAppointments;
    private JTextField patientAppointmentTime;
    private JTextField patientAppointmentDoctor;
    private JTextField patientAppointmentNotes;
    private JTextField patientID;
    private JPanel doctorAccManage;
    private JList doctorAccounts;
    private JTextField txtDocFirst;
    private JTextField txtDocSur;
    private JTextField txtDocGen;
    private JTextField txtDocAdd;
    private JTextField txtDocCity;
    private JTextField txtDocCounty;
    private JTextField txtDocPost;
    private JButton btnAddDoc;
    private JButton btnDeleteDoc;
    private JTextField txtDeleteDoctor;
    private JPasswordField txtDocPass;
    private JPasswordField txtDocConfPass;

    public gui() {
        //add combo box items
        dropUserType.addItem("Patient");
        dropUserType.addItem("Administrator");

        btnReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check passwords match
                if(Arrays.equals(regPassword.getPassword(), regConfPassword.getPassword())){
                    String type = (String) dropUserType.getSelectedItem();
                    String forename = txtForename.getText();
                    String surname = txtSurname.getText();
                    String gender = txtGender.getText();
                    String address = txtAddress.getText();
                    String city = txtCity.getText();
                    String county = txtCounty.getText();
                    String postcode = txtPostcode.getText();
                    char[] password = regPassword.getPassword();
                    String complete = (String) loginRegistrationController.registerUser(gui, type, password, forename, surname, address, city, county, postcode, gender);
                    if(complete.equals("complete")){
                        txtForename.setText("");
                        txtSurname.setText("");
                        txtGender.setText("");
                        txtAddress.setText("");
                        txtCity.setText("");
                        txtCounty.setText("");
                        txtPostcode.setText("");
                        regPassword.setText("");
                        regConfPassword.setText("");
                    }
                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Please ensure passwords match.");
                }
            }
        });

        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = txtUserIDLogin.getText();
                char[] password = txtPassLogin.getPassword();
                loginRegistrationController.logIn(userID, password, gui);
                txtUserIDLogin.setText("");
                txtPassLogin.setText("");
            }
        });
        SecAccManagement.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedPatient = (String)SecAccManagement.getSelectedValue();
                String patient = "";
                for(int i = 12; i < 16; i++){
                    char ch = selectedPatient.charAt(i);
                    patient = patient + String.valueOf(ch);
                }
                secretaryController.getPatientDetails(patient, gui);
            }
        });
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutController.logoutUser(gui);
            }
        });
        btnAuthorise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = txtAuthoriseUserID.getText();
                secretaryController.authorisePatient(userID, gui);
                txtAuthoriseUserID.setText("");
            }
        });
        btnDeletePatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = txtDeletePatient.getText();
                secretaryController.deletePatient(userID, gui);
                txtDeletePatient.setText("");
            }
        });
        patientCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = (String)patientCombo.getSelectedItem();
                doctorController.updateAppointmentList(userID, appointmentsList, gui);
            }
        });
        patientAppointments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selection = patientAppointments.getSelectedIndex();
                patientController.appointmentDetails(gui, selection);
            }
        });
        updatePatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPatient = (String)SecAccManagement.getSelectedValue();
                String patient = "";
                for(int i = 12; i < 16; i++){
                    char ch = selectedPatient.charAt(i);
                    patient = patient + String.valueOf(ch);
                }
                secretaryController.updatePatientDetails(patient, gui, gui.getSecAccManagement());
            }
        });
        btnDeleteDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorController.deleteDoctor(gui.txtDeleteDoctor.getText(), gui);
            }
        });
        btnAddDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check passwords match
                if(Arrays.equals(txtDocPass.getPassword(), txtDocConfPass.getPassword())){
                    String forename = txtDocFirst.getText();
                    String surname = txtDocSur.getText();
                    String address = txtDocAdd.getText();
                    String city = txtDocCity.getText();
                    String county = txtDocCounty.getText();
                    String postcode = txtDocPost.getText();
                    char[] password = txtDocPass.getPassword();
                    String complete = (String) administratorController.registerDoctor(gui, password, forename, surname, address, city, county, postcode);
                    if(complete.equals("complete")){
                        txtDocFirst.setText("");
                        txtDocSur.setText("");
                        txtDocAdd.setText("");
                        txtDocCity.setText("");
                        txtDocCounty.setText("");
                        txtDocPost.setText("");
                        txtDocPass.setText("");
                        txtDocConfPass.setText("");
                    }
                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Please ensure passwords match.");
                }
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

        //function used to implement start up example data
        setUpData.addStartUpData();

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

    public JList getSecAccManagement() {
        return SecAccManagement;
    }

    public void setSecAccManagement(JList secAccManagement) {
        SecAccManagement = secAccManagement;
    }

    public JTextField getPtntFirstName() {
        return ptntFirstName;
    }

    public void setPtntFirstName(JTextField ptntFirstName) {
        this.ptntFirstName = ptntFirstName;
    }

    public JTextField getPtntSurname() {
        return ptntSurname;
    }

    public void setPtntSurname(JTextField ptntSurname) {
        this.ptntSurname = ptntSurname;
    }

    public JTextField getPtntGender() {
        return ptntGender;
    }

    public void setPtntGender(JTextField ptntGender) {
        this.ptntGender = ptntGender;
    }

    public JTextField getPtntAddress() {
        return ptntAddress;
    }

    public void setPtntAddress(JTextField ptntAddress) {
        this.ptntAddress = ptntAddress;
    }

    public JTextField getPtntCity() {
        return ptntCity;
    }

    public void setPtntCity(JTextField ptntCity) {
        this.ptntCity = ptntCity;
    }

    public JTextField getPtntCounty() {
        return ptntCounty;
    }

    public void setPtntCounty(JTextField ptntCounty) {
        this.ptntCounty = ptntCounty;
    }

    public JTextField getPtntPostcode() {
        return ptntPostcode;
    }

    public void setPtntPostcode(JTextField ptntPostcode) {
        this.ptntPostcode = ptntPostcode;
    }

    public JTextField getPtntAuthorised() {
        return ptntAuthorised;
    }

    public void setPtntAuthorised(JTextField ptntAuthorised) {
        this.ptntAuthorised = ptntAuthorised;
    }

    public JTextField getTxtAuthoriseUserID() {
        return txtAuthoriseUserID;
    }

    public void setTxtAuthoriseUserID(JTextField txtAuthoriseUserID) {
        this.txtAuthoriseUserID = txtAuthoriseUserID;
    }

    public JPanel getPatientsPanel() {
        return patientsPanel;
    }

    public void setPatientsPanel(JPanel patientsPanel) {
        this.patientsPanel = patientsPanel;
    }

    public JList getAppointmentsList() {
        return appointmentsList;
    }

    public void setAppointmentsList(JList appointmentsList) {
        this.appointmentsList = appointmentsList;
    }

    public JComboBox getPatientCombo() {
        return patientCombo;
    }

    public void setPatientCombo(JComboBox patientCombo) {
        this.patientCombo = patientCombo;
    }

    public JTextField getPtFirstName() {
        return ptFirstName;
    }

    public void setPtFirstName(JTextField ptFirstName) {
        this.ptFirstName = ptFirstName;
    }

    public JTextField getPtSurname() {
        return ptSurname;
    }

    public void setPtSurname(JTextField ptSurname) {
        this.ptSurname = ptSurname;
    }

    public JTextField getPtGender() {
        return ptGender;
    }

    public void setPtGender(JTextField ptGender) {
        this.ptGender = ptGender;
    }

    public JTextField getPtAddress() {
        return ptAddress;
    }

    public void setPtAddress(JTextField ptAddress) {
        this.ptAddress = ptAddress;
    }

    public JTextField getPtCity() {
        return ptCity;
    }

    public void setPtCity(JTextField ptCity) {
        this.ptCity = ptCity;
    }

    public JTextField getPtCounty() {
        return ptCounty;
    }

    public void setPtCounty(JTextField ptCounty) {
        this.ptCounty = ptCounty;
    }

    public JTextField getPtPostcode() {
        return ptPostcode;
    }

    public void setPtPostcode(JTextField ptPostcode) {
        this.ptPostcode = ptPostcode;
    }

    public JComboBox getPatientAppointments() {
        return patientAppointments;
    }

    public void setPatientAppointments(JComboBox patientAppointments) {
        this.patientAppointments = patientAppointments;
    }

    public JTextField getPatientAppointmentTime() {
        return patientAppointmentTime;
    }

    public void setPatientAppointmentTime(JTextField patientAppointmentTime) {
        this.patientAppointmentTime = patientAppointmentTime;
    }

    public JTextField getPatientAppointmentDoctor() {
        return patientAppointmentDoctor;
    }

    public void setPatientAppointmentDoctor(JTextField patientAppointmentDoctor) {
        this.patientAppointmentDoctor = patientAppointmentDoctor;
    }

    public JTextField getPatientAppointmentNotes() {
        return patientAppointmentNotes;
    }

    public void setPatientAppointmentNotes(JTextField patientAppointmentNotes) {
        this.patientAppointmentNotes = patientAppointmentNotes;
    }

    public JTextField getPatientID() {
        return patientID;
    }

    public void setPatientID(JTextField patientID) {
        this.patientID = patientID;
    }

    public JPanel getDoctorAccManage() {
        return doctorAccManage;
    }

    public void setDoctorAccManage(JPanel doctorAccManage) {
        this.doctorAccManage = doctorAccManage;
    }

    public JList getDoctorAccounts() {
        return doctorAccounts;
    }

    public void setDoctorAccounts(JList doctorAccounts) {
        this.doctorAccounts = doctorAccounts;
    }

    public JTextField getTxtDocFirst() {
        return txtDocFirst;
    }

    public void setTxtDocFirst(JTextField txtDocFirst) {
        this.txtDocFirst = txtDocFirst;
    }

    public JTextField getTxtDocSur() {
        return txtDocSur;
    }

    public void setTxtDocSur(JTextField txtDocSur) {
        this.txtDocSur = txtDocSur;
    }

    public JTextField getTxtDocGen() {
        return txtDocGen;
    }

    public void setTxtDocGen(JTextField txtDocGen) {
        this.txtDocGen = txtDocGen;
    }

    public JTextField getTxtDocAdd() {
        return txtDocAdd;
    }

    public void setTxtDocAdd(JTextField txtDocAdd) {
        this.txtDocAdd = txtDocAdd;
    }

    public JTextField getTxtDocCity() {
        return txtDocCity;
    }

    public void setTxtDocCity(JTextField txtDocCity) {
        this.txtDocCity = txtDocCity;
    }

    public JTextField getTxtDocCounty() {
        return txtDocCounty;
    }

    public void setTxtDocCounty(JTextField txtDocCounty) {
        this.txtDocCounty = txtDocCounty;
    }

    public JTextField getTxtDocPost() {
        return txtDocPost;
    }

    public void setTxtDocPost(JTextField txtDocPost) {
        this.txtDocPost = txtDocPost;
    }

    public JButton getBtnAddDoc() {
        return btnAddDoc;
    }

    public void setBtnAddDoc(JButton btnAddDoc) {
        this.btnAddDoc = btnAddDoc;
    }

    public JButton getBtnDeleteDoc() {
        return btnDeleteDoc;
    }

    public void setBtnDeleteDoc(JButton btnDeleteDoc) {
        this.btnDeleteDoc = btnDeleteDoc;
    }

    public JTextField getTxtDeleteDoctor() {
        return txtDeleteDoctor;
    }

    public void setTxtDeleteDoctor(JTextField txtDeleteDoctor) {
        this.txtDeleteDoctor = txtDeleteDoctor;
    }

    public JPasswordField getTxtDocPass() {
        return txtDocPass;
    }

    public void setTxtDocPass(JPasswordField txtDocPass) {
        this.txtDocPass = txtDocPass;
    }

    public JPasswordField getTxtDocConfPass() {
        return txtDocConfPass;
    }

    public void setTxtDocConfPass(JPasswordField txtDocConfPass) {
        this.txtDocConfPass = txtDocConfPass;
    }
}





