import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;

import java.util.Vector;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;

import java.time.LocalDate;
import java.util.Hashtable;

import com.toedter.calendar.JDateChooser;

import java.util.Date;

public class EmployeeUi extends JFrame {

    JTable tblEmployee;
    JComboBox<Object> cmbSearchGender;
    JComboBox<Object> cmbSearchDesignation;
    JTextField txtSearchName;
    Vector titles;

    JTextField txtName;
    JTextField txtNic;
    JTextField txtMobile;
    JTextField txtEmail;
    JTextField txtDate;

    JComboBox<Object> cmbGender;
    JComboBox<Object> cmbDesignation;
    JComboBox<Object> cmbStatusemployee;

    Hashtable<String, String> regexname;

    // JComboBox<Object> cmbDobYear;
    // JComboBox<Object> cmbDobMonth;
    // JComboBox<Object> cmbDobDay;

    JButton btnAdd;
    JButton btnClear;
    JButton btnUpdate;
    JButton btnDelete;
    JButton btnSearchClear;
    JButton btnSearch;

    Color valid;
    Color invalid;
    Color initial;
    Color updated;

    List<Employee> emplist;
    List<Gender> genlist;
    List<Designation> deslist;
    List<Statusemployee> stslist;

    Employee oldEmployee;
    Employee employee;
    JDateChooser dteDob;

    ImageIcon image1;
    ImageIcon image2;
    ImageIcon image3;
    ImageIcon image4;
    ImageIcon image5;
    ImageIcon image6;

    ImageIcon image7;
    ImageIcon image8;
    ImageIcon image9;
    ImageIcon image10;
    ImageIcon image11;
    ImageIcon image12;

    EmployeeUi() {

        valid = new Color(200, 255, 200);
        invalid = Color.PINK;
        initial = Color.WHITE;
        updated = Color.YELLOW;

        setTitle("Harvest_Super");
        setLocation(400, 70);
        setSize(600, 640);

        Color C = Color.CYAN;
        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);
        con.setBackground(C);

        JLabel lblName = new JLabel("Name : ");
        JLabel lblDob = new JLabel("DOB : ");
        JLabel lblGender = new JLabel("Gender : ");
        JLabel lblNic = new JLabel("NIC : ");
        JLabel lblMobile = new JLabel("Mobile No : ");
        JLabel lblEmail = new JLabel("Email : ");
        JLabel lblDesignation = new JLabel("Designation : ");
        JLabel lblStatus = new JLabel("Status : ");

        txtName = new JTextField(46);
        txtNic = new JTextField(46);
        txtMobile = new JTextField(46);
        txtEmail = new JTextField(46);

        cmbGender = new JComboBox();
        cmbDesignation = new JComboBox();
        cmbStatusemployee = new JComboBox();

        dteDob = new JDateChooser();

        image1 = new ImageIcon("ADD.png");
        image2 = new ImageIcon("Delete.png");
        image3 = new ImageIcon("Update.png");
        image4 = new ImageIcon("Clear.png");
        image5 = new ImageIcon("Search.png");
        image6 = new ImageIcon("ClearSearch.png");

        image7 = new ImageIcon("ADD2.png");
        image8 = new ImageIcon("Delete2.png");
        image9 = new ImageIcon("Update2.png");
        image10 = new ImageIcon("Clear2.png");
        image11 = new ImageIcon("Search2.png");
        image12 = new ImageIcon("ClearSearch2.png");

        btnAdd = new JButton(image1);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFocusPainted(false);
        btnAdd.setBorderPainted(false);
        // btnAdd.setBackground(Color.BLUE);

        btnClear = new JButton(image4);
        btnClear.setContentAreaFilled(false);
        btnClear.setFocusPainted(false);
        btnClear.setBorderPainted(false);

        btnUpdate = new JButton(image3);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setFocusPainted(false);
        btnUpdate.setBorderPainted(false);

        btnDelete = new JButton(image2);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setFocusPainted(false);
        btnDelete.setBorderPainted(false);

        btnSearchClear = new JButton(image6);
        btnSearchClear.setContentAreaFilled(false);
        btnSearchClear.setFocusPainted(false);
        btnSearchClear.setBorderPainted(false);

        btnSearch = new JButton(image5);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setBorderPainted(false);

        con.add(lblName);
        con.add(txtName);
        con.add(lblDob);
        con.add(dteDob);

        con.add(lblGender);
        con.add(cmbGender);
        JLabel lblFormpart1 = new JLabel(
                "-------------------------------------------------------------------------------------------------------------------------------------------");
        con.add(lblFormpart1);
        con.add(lblNic);
        con.add(txtNic);
        con.add(lblMobile);
        con.add(txtMobile);
        con.add(lblEmail);
        con.add(txtEmail);
        con.add(lblDesignation);
        con.add(cmbDesignation);
        con.add(lblStatus);
        con.add(cmbStatusemployee);
        JLabel lblFormpart2 = new JLabel(
                "-------------------------------------------------------------------------------------------------------------------------------------------");
        con.add(lblFormpart2);

        con.add(btnDelete);
        con.add(btnUpdate);
        con.add(btnClear);
        con.add(btnAdd);
        JLabel lblSearcharea1 = new JLabel(
                "-------------------------------------------------------------------------------------------------------------------------------------------");
        con.add(lblSearcharea1);

        JLabel lblSearchName = new JLabel("Name : ");
        txtSearchName = new JTextField(10);
        JLabel lblSearchGender = new JLabel("Gender : ");
        cmbSearchGender = new JComboBox();
        JLabel lblSearchDesignation = new JLabel("Designation : ");
        cmbSearchDesignation = new JComboBox();

        con.add(lblSearchName);
        con.add(txtSearchName);
        con.add(lblSearchGender);
        con.add(cmbSearchGender);
        con.add(lblSearchDesignation);
        con.add(cmbSearchDesignation);
        JLabel lblSearcharea2 = new JLabel(
                "-------------------------------------------------------------------------------------------------------------------------------------------");
        con.add(lblSearcharea2);

        con.add(btnSearchClear);
        con.add(btnSearch);

        titles = new Vector();
        titles.add("Name");
        titles.add("DOB");
        titles.add("NIC");
        titles.add("Gender");
        titles.add("Designation");

        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblEmployee = new JTable();
        tblEmployee.setModel(dataModel);
        Color T = Color.LIGHT_GRAY;
        tblEmployee.setBackground(T);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize(new Dimension(500, 200));
        jspTable.setViewportView(tblEmployee);

        con.add(jspTable);

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSearchAp(e);
            }
        });

        btnSearch.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                btnSearchAp1(e);
            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
                btnSearchAp2(e);

            }
        });

        btnSearchClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSearchClearAp(e);
            }
        });

        btnSearchClear.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                btnSearchClearAp1(e);
            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
                btnSearchClearAp2(e);

            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAddAp(e);
            }
        });

        btnAdd.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                btnAddAp1(e);
            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
                btnAddAp2(e);

            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnClearAp(e);
            }
        });

        btnClear.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                btnClearAp1(e);
            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
                btnClearAp2(e);

            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnUpdateAp(e);
            }
        });

        btnUpdate.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                btnUpdateAp1(e);
            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
                btnUpdateAp2(e);

            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnDeleteAp(e);
            }
        });

        btnDelete.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                btnDeleteAp1(e);
            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
                btnDeleteAp2(e);

            }
        });

        tblEmployee.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tblEmployeeVC(e);
            }
        });

        dteDob.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                dteDobPc(e);
            }
        });

        intitialize();

        // Real Time Validation

        cmbGender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmbGenderAp(e);
            }
        });

        cmbDesignation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmbDesignationAp(e);
            }
        });

        cmbStatusemployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmbStatusemployeeAp(e);
            }
        });

        txtName.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                txtNameKR(e);
            }

        });

        txtNic.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                txtNicKR(e);
            }

        });

        txtEmail.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                txtEmailKR(e);
            }

        });

        txtMobile.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                txtMobileKR(e);
            }

        });

    }

    public void intitialize() {

        regexname = RegexProvider.get();
        loadForm();
        loadView();

    }

    public void btnAddAp1(MouseEvent e) {

        btnAdd.setIcon(image7);

    }

    public void btnAddAp2(MouseEvent e) {

        btnAdd.setIcon(image1);

    }

    public void btnClearAp1(MouseEvent e) {

        btnClear.setIcon(image10);

    }

    public void btnClearAp2(MouseEvent e) {

        btnClear.setIcon(image4);

    }

    public void btnDeleteAp1(MouseEvent e) {

        btnDelete.setIcon(image8);

    }

    public void btnDeleteAp2(MouseEvent e) {

        btnDelete.setIcon(image2);

    }

    public void btnUpdateAp1(MouseEvent e) {

        btnUpdate.setIcon(image9);

    }

    public void btnUpdateAp2(MouseEvent e) {

        btnUpdate.setIcon(image3);

    }

    public void btnSearchAp1(MouseEvent e) {

        btnSearch.setIcon(image11);

    }

    public void btnSearchAp2(MouseEvent e) {

        btnSearch.setIcon(image5);

    }

    public void btnSearchClearAp1(MouseEvent e) {

        btnSearchClear.setIcon(image12);

    }

    public void btnSearchClearAp2(MouseEvent e) {

        btnSearchClear.setIcon(image6);

    }

    // UI-Controller Interactive
    // Real Time Validation Binding

    public void txtNameKR(KeyEvent e) {

        String name = txtName.getText();

        if (name.matches(regexname.get("name"))) { // "^[A-Z][a-z]*$"
            employee.setName(name);
            txtName.setBackground(valid);
            if (oldEmployee != null)
                if (!employee.getName().equals(oldEmployee.getName()))
                    txtName.setBackground(updated);
            // else
            // txtName.setBackground(valid);
        }

        else {
            txtName.setBackground(invalid);
            employee.setName(null);
            // error = error + "\n Invalid Name";
        }

    }

    public void dteDobPc(PropertyChangeEvent e) {

        java.util.Date dt = dteDob.getDate();
        if (dt != null) {
            LocalDate dob = LocalDate.of(dt.getYear() + 1900, dt.getMonth() + 1, dt.getDate());
            ;
            // System.out.println(dob);
            LocalDate today = LocalDate.now();
            // System.out.println(today);
            int age = today.getYear() - dob.getYear();
            // System.out.println(age);
            JTextField txtDate = (JTextField) dteDob.getDateEditor().getUiComponent();
            if (age >= 18) {
                employee.setDob(dob);
                txtDate.setBackground(valid);
            }
            // if(oldEmployee != null)
            // if(!employee.getDob().equals(oldEmployee.getDob()))
            // txtDate.setBackground(updated);
            else {
                employee.setDob(null);
                txtDate.setBackground(invalid);
            }
            if (oldEmployee != null)
                if (!employee.getDob().equals(oldEmployee.getDob()))
                    txtDate.setBackground(updated);
        }

    }

    public void txtNicKR(KeyEvent e) {

        String nic = txtNic.getText();
        if (nic.matches(regexname.get("nic"))) { // "^[0-9]{9}V$"
            employee.setNic(nic);
            txtNic.setBackground(valid);
            if (oldEmployee != null)
                if (!employee.getNic().equals(oldEmployee.getNic()))
                    txtNic.setBackground(updated);
            // else
            // txtNic.setBackground(valid);
        } else {
            txtNic.setBackground(invalid);
            // error = error + "\n Invalid NIC";
        }

    }

    public void txtEmailKR(KeyEvent e) {

        String email = txtEmail.getText();
        if (email.matches(regexname.get("email"))) { // "^[a-z]*@[a-z]*.[a-z]*$"
            employee.setEmail(email);
            txtEmail.setBackground(valid);
            if (oldEmployee != null)
                if (!employee.getEmail().equals(oldEmployee.getEmail()))
                    txtEmail.setBackground(updated);
            // else
            // txtEmail.setBackground(valid);
        } else {
            txtEmail.setBackground(invalid);
            // error = error + "\n Invalid Email";
        }

    }

    public void txtMobileKR(KeyEvent e) {

        String mobile = txtMobile.getText();
        if (mobile.matches(regexname.get("mobile"))) { // "^0[0-9]{9}$"
            employee.setMobile(mobile);
            txtMobile.setBackground(valid);
            if (oldEmployee != null)
                if (!employee.getMobile().equals(oldEmployee.getMobile()))
                    txtMobile.setBackground(updated);
            // else
            // txtMobile.setBackground(valid);
        } else {
            txtMobile.setBackground(invalid);
            // error = error + "\n Invalid Mobile Number";
        }

    }

    public void cmbGenderAp(ActionEvent e) {

        int genindex = cmbGender.getSelectedIndex();
        if (genindex != 0) {
            cmbGender.setBackground(valid);
            employee.setGender((Gender) cmbGender.getSelectedItem());
            if (oldEmployee != null)
                if (!employee.getGender().equals(oldEmployee.getGender()))
                    cmbGender.setBackground(updated);
                else {
                }
        } else {
            cmbGender.setBackground(invalid);
            // error = error + "\n Gender Not Selected";
        }
    }

    public void cmbDesignationAp(ActionEvent e) {

        int desindex = cmbDesignation.getSelectedIndex();
        if (desindex != 0) {
            cmbDesignation.setBackground(valid);
            employee.setDesignation((Designation) cmbDesignation.getSelectedItem());
            if (oldEmployee != null)
                if (!employee.getDesignation().equals(oldEmployee.getDesignation()))
                    cmbDesignation.setBackground(updated);
                else {
                }
        } else {
            cmbDesignation.setBackground(invalid);
            // error = error + "\n Designation Not Selected";
        }
    }

    public void cmbStatusemployeeAp(ActionEvent e) {

        int stsindex = cmbStatusemployee.getSelectedIndex();
        if (stsindex != 0) {
            cmbStatusemployee.setBackground(valid);
            employee.setStatusEmployee((Statusemployee) cmbStatusemployee.getSelectedItem());
            if (oldEmployee != null)
                if (!employee.getStatusEmployee().equals(oldEmployee.getStatusEmployee()))
                    cmbStatusemployee.setBackground(updated);
                else {
                }
        } else {
            cmbStatusemployee.setBackground(invalid);
            // error = error + "\n Statusemployee Not Selected";
        }
    }

    public void loadForm() {

        employee = new Employee();

        genlist = GenderController.get();
        Vector<Object> genders = new Vector();
        genders.add("Select a Gender");

        for (Gender gen : genlist) {
            genders.add(gen);
        }

        DefaultComboBoxModel<Object> gndModel = new DefaultComboBoxModel(genders);
        cmbGender.setModel(gndModel);

        deslist = DesignationController.get();
        Vector<Object> designations = new Vector();
        designations.add("Select a Designation");

        for (Designation des : deslist) {
            designations.add(des);
        }

        DefaultComboBoxModel<Object> desModel = new DefaultComboBoxModel(designations);
        cmbDesignation.setModel(desModel);

        stslist = StatusemployeeController.get();
        Vector<Object> statusemployees = new Vector();
        statusemployees.add("Select a Status");

        for (Statusemployee sts : stslist) {
            statusemployees.add(sts);
        }

        DefaultComboBoxModel<Object> stsModel = new DefaultComboBoxModel(statusemployees);
        cmbStatusemployee.setModel(stsModel);

        JTextField txtDate = (JTextField) dteDob.getDateEditor().getUiComponent();
        txtDate.setText(null);
        // txtDate.setBackground(initial);

        txtName.setText("");
        txtNic.setText("");
        txtMobile.setText("07");
        txtEmail.setText("@gmail.com");

        enableButtons(true, false, false);
        setStyle(initial);

    }

    public void enableButtons(boolean add, boolean upd, boolean del) {
        btnAdd.setEnabled(add);
        btnUpdate.setEnabled(upd);
        btnDelete.setEnabled(del);
    }

    public void setStyle(Color clr) {

        txtName.setBackground(clr);
        txtMobile.setBackground(clr);
        txtEmail.setBackground(clr);
        txtNic.setBackground(clr);
        txtName.setBackground(clr);
        JTextField txtDate = (JTextField) dteDob.getDateEditor().getUiComponent();
        txtDate.setBackground(clr);

        cmbDesignation.setBackground(clr);
        cmbGender.setBackground(clr);
        cmbStatusemployee.setBackground(clr);

    }

    public void fillForm() {

        enableButtons(false, true, true);
        setStyle(valid);

    }

    public void loadView() {

        emplist = EmployeeController.get(null);
        fillTable(emplist);

        List<Gender> genlist = GenderController.get();
        Vector<Object> genders = new Vector();
        genders.add("Select a Gender");

        for (Gender gen : genlist) {
            genders.add(gen);
        }

        DefaultComboBoxModel<Object> gndModel = new DefaultComboBoxModel(genders);
        cmbSearchGender.setModel(gndModel);

        List<Designation> deslist = DesignationController.get();
        Vector<Object> designations = new Vector();
        designations.add("Select a Designation");

        for (Designation des : deslist) {
            designations.add(des);
        }

        DefaultComboBoxModel<Object> desModel = new DefaultComboBoxModel(designations);
        cmbSearchDesignation.setModel(desModel);

    }

    public void fillTable(List<Employee> employees) {

        Vector data = new Vector();

        for (Employee emp : employees) {

            Vector r = new Vector();
            r.add(emp.getName());
            r.add(emp.getDob().toString());
            r.add(emp.getNic());
            r.add(emp.getGender().getName());
            r.add(emp.getDesignation().getName());
            data.add(r);

        }

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblEmployee.setModel(dataModel);

    }

    public void btnSearchAp(ActionEvent e) {

        String name = txtSearchName.getText();

        Object sitem = cmbSearchGender.getSelectedItem();
        Gender gender = null;

        Object sitem2 = cmbSearchDesignation.getSelectedItem();
        Designation designation = null;

        if (!sitem.equals("Select a Gender"))
            gender = (Gender) sitem;

        if (!sitem2.equals("Select a Designation"))
            designation = (Designation) sitem2;

        Hashtable<String, Object> ht = new Hashtable();
        ht.put("name", name);
        if (gender != null)
            ht.put("gender", gender);

        ht.put("name", name);
        if (designation != null)
            ht.put("designation", designation);

        List<Employee> employees = EmployeeController.get(ht);
        fillTable(employees);

    }

    public void btnSearchClearAp(ActionEvent e) {

        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Clear the Search");

        if (opt != 1) {

            txtSearchName.setText("");
            cmbSearchGender.setSelectedIndex(0);
            cmbSearchDesignation.setSelectedIndex(0);

            List<Employee> employees = EmployeeController.get(null);
            fillTable(employees);

        }

    }

    public String geterrors() {

        String error = "";

        if (employee.getName() == null)
            error = error + "\n Invalid Name";
        if (employee.getDob() == null)
            error = error + "\n DOB is Not Selected";
        if (employee.getNic() == null)
            error = error + "\n Invalid Nic";
        if (employee.getMobile() == null)
            error = error + "\n Invalid Mobile";
        if (employee.getEmail() == null)
            error = error + "\n Invalid Email";
        if (employee.getGender() == null)
            error = error + "\n Gender is Not Selected";
        if (employee.getDesignation() == null)
            error = error + "\n Designation is Not Selected";
        if (employee.getStatusEmployee() == null)
            error = error + "\n Status is Not Selected";

        return error;

    }

    public void btnAddAp(ActionEvent e) {

        String error = geterrors();

        if (error.isEmpty()) {

            String cnfmsg = "Are you sure to save following Employee?\n\n";
            cnfmsg = cnfmsg + "\nName : " + employee.getName();
            cnfmsg = cnfmsg + "\nName : " + employee.getDob().toString();
            cnfmsg = cnfmsg + "\nNIC : " + employee.getNic();
            cnfmsg = cnfmsg + "\nGender : " + employee.getGender().getName();
            cnfmsg = cnfmsg + "\nDesignation : " + employee.getDesignation().getName();
            cnfmsg = cnfmsg + "\nMobile : " + employee.getMobile();
            cnfmsg = cnfmsg + "\nEmail : " + employee.getEmail();
            cnfmsg = cnfmsg + "\nStaus : " + employee.getStatusEmployee().getName();

            int conf = JOptionPane.showConfirmDialog(null, cnfmsg);

            if (conf == 0) {
                String st = EmployeeController.post(employee);
                if (st.equals("1")) {
                    loadView();
                    loadForm();
                    JOptionPane.showMessageDialog(null, "Successfully Saved");
                } else
                    JOptionPane.showMessageDialog(null, "Faild to Save as \n\n" + st);
            }

        } else {
            JOptionPane.showMessageDialog(null, error);
        }

    }

    public void tblEmployeeVC(ListSelectionEvent e) {
        int row = tblEmployee.getSelectedRow();
        if (row > -1) {
            Employee employee = emplist.get(row);
            fillForm(employee);
        }
    }

    public void cmbDobAp(ActionEvent e) {

        java.util.Date dt = dteDob.getDate();
        LocalDate dob = LocalDate.of(dt.getYear() + 1990, dt.getMonth() + 1, dt.getDate());
        employee.setDob(dob);

    }

    public void fillForm(Employee emp) {

        oldEmployee = emp;

        employee = new Employee();

        employee.setName(emp.getName());
        employee.setNic(emp.getNic());
        employee.setMobile(emp.getMobile());
        employee.setEmail(emp.getEmail());
        employee.setDesignation(emp.getDesignation());
        employee.setGender(emp.getGender());
        employee.setStatusEmployee(emp.getStatusEmployee());
        employee.setDob(emp.getDob());

        txtName.setText(emp.getName());
        txtNic.setText(emp.getNic());
        txtMobile.setText(emp.getMobile());
        txtEmail.setText(emp.getEmail());

        for (Gender gen : genlist) {
            if (gen.equals(employee.getGender())) {
                cmbGender.setSelectedItem(gen);
                break;
            }
        }

        for (Designation des : deslist) {
            if (des.getId() == employee.getDesignation().getId()) {
                cmbDesignation.setSelectedItem(des);
                break;
            }
        }

        for (Statusemployee sts : stslist) {
            if (sts.getId() == employee.getStatusEmployee().getId()) {
                cmbStatusemployee.setSelectedItem(sts);
                break;
            }
        }

        dteDob.setDate(new java.util.Date(employee.getDob().toEpochDay()));

        int year = emp.getDob().getYear();
        int month = emp.getDob().getMonthValue();
        int day = emp.getDob().getDayOfMonth();

        java.util.Date dob = new java.util.Date(year - 1900, month - 1, day);

        dteDob.setDate(dob);
        dteDob.updateUI();

        enableButtons(false, true, true);
        setStyle(valid);

    }

    public void btnClearAp(ActionEvent e) {
        int conf = JOptionPane.showConfirmDialog(null, "Are You Sure To Clear The Form ?");

        if (conf == 0)
            loadForm();
        oldEmployee = null;
    }

    public String getUpdates() {

        String updates = "";

        if (!employee.getName().equals(oldEmployee.getName()))
            updates = updates + "\n Name Updated" + " - " + employee.getName();

        if (!employee.getNic().equals(oldEmployee.getNic()))
            updates = updates + "\n Nic Updated" + " - " + employee.getNic();

        if (!employee.getEmail().equals(oldEmployee.getEmail()))
            updates = updates + "\n Email Updated" + " - " + employee.getEmail();

        if (!employee.getMobile().equals(oldEmployee.getMobile()))
            updates = updates + "\n Mobile Updated" + " - " + employee.getMobile();

        if (!employee.getGender().equals(oldEmployee.getGender()))
            updates = updates + "\n Gender Updated" + " - " + (Gender) cmbGender.getSelectedItem();

        if (!employee.getDesignation().equals(oldEmployee.getDesignation()))
            updates = updates + "\n Designation Updated" + " - " + (Designation) cmbDesignation.getSelectedItem();

        if (!employee.getStatusEmployee().equals(oldEmployee.getStatusEmployee()))
            updates = updates + "\n Status Updated" + " - " + (Statusemployee) cmbStatusemployee.getSelectedItem();

        if (!employee.getDob().equals(oldEmployee.getDob())) {
            Date dt = dteDob.getDate();
            if (dt != null) {
                LocalDate dob = LocalDate.of(dt.getYear() + 1900, dt.getMonth() + 1, dt.getDate());
                LocalDate today = LocalDate.now();
                int age = today.getYear() - dob.getYear();
                txtDate = (JTextField) dteDob.getDateEditor().getUiComponent();
                if (age >= 18 && !employee.getDob().equals(oldEmployee.getDob()))
                    ;
                updates = updates + "\n Birth Date Update";
            }
        }

        return updates;
    }

    public void btnUpdateAp(ActionEvent e) {

        // employee = new Employee();
        employee.setId(oldEmployee.getId());

        String error = geterrors();

        if (error.isEmpty()) {
            String updates = getUpdates();

            if (!updates.isEmpty()) {
                int resp = JOptionPane.showConfirmDialog(null, "You Have Following Updates\n\n" + updates);
                if (resp == 0) {
                    String status = EmployeeController.put(employee);
                    if (status.equals("1")) {

                        int lsrow = tblEmployee.getSelectedRow();

                        loadView();
                        loadForm();
                        tblEmployee.setRowSelectionInterval(lsrow, lsrow);
                        JOptionPane.showMessageDialog(null, "Succesfully Updated");

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed To Update As \n\n" + status);
                    }

                }
            }

            else {
                JOptionPane.showMessageDialog(null, "Nothing To Be Update");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Have Following Errors\n\n" + error);
        }

    }

    public void btnDeleteAp(ActionEvent e) {

        int resp = JOptionPane.showConfirmDialog(null,
                "Are You Sure To Delete Following Employee?\n\n" + oldEmployee.getName());
        if (resp == 0) {
            String status = EmployeeController.delete(oldEmployee);
            if (status.equals("1")) {

                loadView();
                loadForm();

                JOptionPane.showMessageDialog(null, "Succsesfully Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Failed To Delete as \n\n" + status);
            }
        }
        oldEmployee = null;

    }

}
