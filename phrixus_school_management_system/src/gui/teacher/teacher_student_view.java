/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.teacher;

import Controller.ClassRoomController;
import Controller.GuardianController;
import Controller.GuardianRelationshipController;
import Controller.StudentController;
import Model.ClassRoom;
import Model.Guardian;
import Model.Student;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lahiru Sandeepa
 */
public class teacher_student_view extends javax.swing.JInternalFrame {
       private ArrayList<Student> student_details; // these are the result values of search
       private ArrayList<JCheckBox> search_checkBoxs;
       DefaultTableModel searchResult_table ;

    /**
     * Creates new form teacher_student_view
     */
    public teacher_student_view() {
        
        initComponents();
        init_SearchComponents();
    }
    
    public void init_SearchComponents(){
        search_checkBoxs = new ArrayList<>();
        search_checkBoxs.add(index_number_CheakBox);
        search_checkBoxs.add(student_name_CheckBox);
        search_checkBoxs.add(Home_Address_CheckBox);
        search_checkBoxs.add(Contact_number_CheckBox);
        search_checkBoxs.add(MotherName_CheakBox);
        search_checkBoxs.add(fatherName_cheakBox);
        search_checkBoxs.add(FatherOccupation_cheakBox);
        search_checkBoxs.add(FatherTelephone_cheakBox);
        search_checkBoxs.add(MotherOccupation_cheakBox);
        search_checkBoxs.add(MotherTelephone_cheakBox);
        searchResult_table = new DefaultTableModel();
        student_details_table.setModel(searchResult_table);
        student_details = new ArrayList<>();
        
    }
    /*this methord for display result student list by search, */
    public void displaySearchResults(){
        int columnCounter = 0; // count the number of columns add to the table
        int checkBoxCounter = 0; // count itarator for  checkbox arrayList
        for(JCheckBox itemselect : search_checkBoxs){
            if(itemselect.isSelected()){
                searchResult_table.addColumn(itemselect.getText());
                displaysupport_insertingStudentDataToRows(checkBoxCounter, columnCounter);
                columnCounter++;
            }
            checkBoxCounter++;
        }
    }
    public void displaysupport_insertingStudentDataToRows(int index, int column){
        int row = 0;
        switch(index){
            case 0 : // set student_id
                row = 0;
                for(Student st : student_details){
                    student_details_table.setValueAt(st.getStudentId(), row, column);
                    row++;
                }
            case 1: //set student name
                row = 0;
                for(Student st : student_details){
                    student_details_table.setValueAt(st.getFullName(), row, column);
                    row++;
                }
            case 2: //Home address
                 row = 0;
                for(Student st : student_details){
                    student_details_table.setValueAt(st.getResidenceAddress(), row, column);
                    row++;
                }
            case 3: //contact number
                 row = 0;
                for(Student st : student_details){
                    student_details_table.setValueAt(st.getTelephoneNo(), row, column);
                    row++;
                }
            case 4 :// mother name
                row = 0;
                for(Student st : student_details){
                    for(Guardian gardian : st.getGuardianList()){
                        if(gardian.getRelationship().equalsIgnoreCase("Mother")){
                            student_details_table.setValueAt(gardian.getRelationship(), row, column);

                        }
                    }
                    row++;
                }
            case 5: //father name
                 row = 0;
                for(Student st : student_details){
                    for(Guardian gardian : st.getGuardianList()){
                        if(gardian.getRelationship().equalsIgnoreCase("Father")){
                            student_details_table.setValueAt(gardian.getRelationship(), row, column);

                        }
                    }
                    row++;
                }
            case 6: //father occupation
                row = 0;
                for(Student st : student_details){
                    for(Guardian gardian : st.getGuardianList()){
                        if(gardian.getRelationship().equalsIgnoreCase("Father")){
                            student_details_table.setValueAt(gardian.getOccupation(), row, column);

                        }
                    }
                    row++;
                }
            case 7: //father telephone
                 row = 0;
                for(Student st : student_details){
                    for(Guardian gardian : st.getGuardianList()){
                        if(gardian.getRelationship().equalsIgnoreCase("Father")){
                            student_details_table.setValueAt(gardian.getMobileNo(), row, column);

                        }
                    }
                    row++;
                }
            case 8: //mother occupation
                 row = 0;
                for(Student st : student_details){
                    for(Guardian gardian : st.getGuardianList()){
                        if(gardian.getRelationship().equalsIgnoreCase("Mother")){
                            student_details_table.setValueAt(gardian.getOccupation(), row, column);

                        }
                    }
                    row++;
                }
            case 9: // mother telephone
                 row = 0;
                for(Student st : student_details){
                    for(Guardian gardian : st.getGuardianList()){
                        if(gardian.getRelationship().equalsIgnoreCase("Mother")){
                            student_details_table.setValueAt(gardian.getMobileNo(), row, column);

                        }
                    }
                    row++;
                }
                
        }
    }
   
    

        
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Search_btn_group = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Teacher_teacher_view_tabPane = new javax.swing.JTabbedPane();
        Student_search_panel = new javax.swing.JPanel();
        search_student_panel = new javax.swing.JPanel();
        search_studentByComboBox = new javax.swing.JComboBox();
        studentDetails_Search_Btn = new javax.swing.JButton();
        AdvanceSearchTools_panel = new javax.swing.JPanel();
        fatherName_cheakBox = new javax.swing.JCheckBox();
        FatherOccupation_cheakBox = new javax.swing.JCheckBox();
        MotherName_CheakBox = new javax.swing.JCheckBox();
        MotherOccupation_cheakBox = new javax.swing.JCheckBox();
        index_number_CheakBox = new javax.swing.JCheckBox();
        student_name_CheckBox = new javax.swing.JCheckBox();
        Home_Address_CheckBox = new javax.swing.JCheckBox();
        Contact_number_CheckBox = new javax.swing.JCheckBox();
        FatherTelephone_cheakBox = new javax.swing.JCheckBox();
        MotherTelephone_cheakBox = new javax.swing.JCheckBox();
        getFullDetailsOfaStudent_button = new javax.swing.JButton();
        search_textField = new java.awt.TextField();
        Search_inGrade_RadioButton = new javax.swing.JRadioButton();
        Search_inClass_RadioButton = new javax.swing.JRadioButton();
        Search_inSchool_RadioButton = new javax.swing.JRadioButton();
        student_details_panel = new javax.swing.JPanel();
        tabel_scrollPane = new javax.swing.JScrollPane();
        student_details_table = new javax.swing.JTable();
        search_tab_panel = new javax.swing.JPanel();

        search_student_panel.setBackground(new java.awt.Color(255, 255, 255));
        search_student_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Search Teacher")), "Search Student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        search_studentByComboBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        search_studentByComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Search By...", "Student Name", "Student Index" }));
        search_studentByComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_studentByComboBoxKeyPressed(evt);
            }
        });

        studentDetails_Search_Btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        studentDetails_Search_Btn.setText("Search");
        studentDetails_Search_Btn.setBorder(null);
        studentDetails_Search_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDetails_Search_BtnActionPerformed(evt);
            }
        });

        AdvanceSearchTools_panel.setBackground(new java.awt.Color(255, 255, 255));
        AdvanceSearchTools_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Advance Search Tools", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        fatherName_cheakBox.setBackground(new java.awt.Color(255, 255, 255));
        fatherName_cheakBox.setText("Father's Name");
        fatherName_cheakBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatherName_cheakBoxActionPerformed(evt);
            }
        });

        FatherOccupation_cheakBox.setBackground(new java.awt.Color(255, 255, 255));
        FatherOccupation_cheakBox.setText("Father's Occupation");
        FatherOccupation_cheakBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FatherOccupation_cheakBoxActionPerformed(evt);
            }
        });

        MotherName_CheakBox.setBackground(new java.awt.Color(255, 255, 255));
        MotherName_CheakBox.setText("Mother's Name");
        MotherName_CheakBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotherName_CheakBoxActionPerformed(evt);
            }
        });

        MotherOccupation_cheakBox.setBackground(new java.awt.Color(255, 255, 255));
        MotherOccupation_cheakBox.setText("Mother's Occupation");
        MotherOccupation_cheakBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotherOccupation_cheakBoxActionPerformed(evt);
            }
        });

        index_number_CheakBox.setBackground(new java.awt.Color(255, 255, 255));
        index_number_CheakBox.setSelected(true);
        index_number_CheakBox.setText("Index Number");

        student_name_CheckBox.setBackground(new java.awt.Color(255, 255, 255));
        student_name_CheckBox.setSelected(true);
        student_name_CheckBox.setText("Student Name");

        Home_Address_CheckBox.setBackground(new java.awt.Color(255, 255, 255));
        Home_Address_CheckBox.setSelected(true);
        Home_Address_CheckBox.setText("Home Address");
        Home_Address_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home_Address_CheckBoxActionPerformed(evt);
            }
        });

        Contact_number_CheckBox.setBackground(new java.awt.Color(255, 255, 255));
        Contact_number_CheckBox.setSelected(true);
        Contact_number_CheckBox.setText("Contact Number");
        Contact_number_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Contact_number_CheckBoxActionPerformed(evt);
            }
        });

        FatherTelephone_cheakBox.setBackground(new java.awt.Color(255, 255, 255));
        FatherTelephone_cheakBox.setText("Father's TelePhone Number");
        FatherTelephone_cheakBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FatherTelephone_cheakBoxActionPerformed(evt);
            }
        });

        MotherTelephone_cheakBox.setBackground(new java.awt.Color(255, 255, 255));
        MotherTelephone_cheakBox.setText("Mother's TelePhone Number");
        MotherTelephone_cheakBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotherTelephone_cheakBoxActionPerformed(evt);
            }
        });

        getFullDetailsOfaStudent_button.setText("Get Full details of a Student");

        javax.swing.GroupLayout AdvanceSearchTools_panelLayout = new javax.swing.GroupLayout(AdvanceSearchTools_panel);
        AdvanceSearchTools_panel.setLayout(AdvanceSearchTools_panelLayout);
        AdvanceSearchTools_panelLayout.setHorizontalGroup(
            AdvanceSearchTools_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdvanceSearchTools_panelLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(AdvanceSearchTools_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MotherName_CheakBox)
                    .addComponent(index_number_CheakBox)
                    .addComponent(fatherName_cheakBox))
                .addGap(18, 18, 18)
                .addGroup(AdvanceSearchTools_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdvanceSearchTools_panelLayout.createSequentialGroup()
                        .addComponent(student_name_CheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Home_Address_CheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Contact_number_CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdvanceSearchTools_panelLayout.createSequentialGroup()
                        .addGroup(AdvanceSearchTools_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MotherOccupation_cheakBox)
                            .addComponent(FatherOccupation_cheakBox))
                        .addGap(18, 18, 18)
                        .addGroup(AdvanceSearchTools_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AdvanceSearchTools_panelLayout.createSequentialGroup()
                                .addComponent(MotherTelephone_cheakBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(getFullDetailsOfaStudent_button))
                            .addGroup(AdvanceSearchTools_panelLayout.createSequentialGroup()
                                .addComponent(FatherTelephone_cheakBox)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        AdvanceSearchTools_panelLayout.setVerticalGroup(
            AdvanceSearchTools_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdvanceSearchTools_panelLayout.createSequentialGroup()
                .addGroup(AdvanceSearchTools_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(index_number_CheakBox)
                    .addComponent(student_name_CheckBox)
                    .addComponent(Home_Address_CheckBox)
                    .addComponent(Contact_number_CheckBox))
                .addGap(7, 7, 7)
                .addGroup(AdvanceSearchTools_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fatherName_cheakBox)
                    .addComponent(FatherOccupation_cheakBox)
                    .addComponent(FatherTelephone_cheakBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdvanceSearchTools_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MotherName_CheakBox)
                    .addComponent(MotherOccupation_cheakBox)
                    .addComponent(MotherTelephone_cheakBox))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdvanceSearchTools_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(getFullDetailsOfaStudent_button))
        );

        search_textField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        search_textField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_textFieldMouseClicked(evt);
            }
        });
        search_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_textFieldActionPerformed(evt);
            }
        });

        Search_inGrade_RadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Search_inGrade_RadioButton);
        Search_inGrade_RadioButton.setText("Show all the students in the Grade");

        Search_inClass_RadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Search_inClass_RadioButton);
        Search_inClass_RadioButton.setSelected(true);
        Search_inClass_RadioButton.setText("Show all the students in the class");
        Search_inClass_RadioButton.setActionCommand("ss");

        Search_inSchool_RadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Search_inSchool_RadioButton);
        Search_inSchool_RadioButton.setText("Show all the student in the school");

        javax.swing.GroupLayout search_student_panelLayout = new javax.swing.GroupLayout(search_student_panel);
        search_student_panel.setLayout(search_student_panelLayout);
        search_student_panelLayout.setHorizontalGroup(
            search_student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_student_panelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(search_student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AdvanceSearchTools_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(search_student_panelLayout.createSequentialGroup()
                        .addComponent(search_studentByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(search_student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(search_student_panelLayout.createSequentialGroup()
                                .addComponent(Search_inSchool_RadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Search_inGrade_RadioButton)
                                .addGap(4, 4, 4)
                                .addComponent(Search_inClass_RadioButton))
                            .addComponent(search_textField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addComponent(studentDetails_Search_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        search_student_panelLayout.setVerticalGroup(
            search_student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, search_student_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(search_student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_studentByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(search_student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(studentDetails_Search_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(search_student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search_inGrade_RadioButton)
                    .addComponent(Search_inClass_RadioButton)
                    .addComponent(Search_inSchool_RadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AdvanceSearchTools_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        student_details_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        student_details_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabel_scrollPane.setViewportView(student_details_table);

        javax.swing.GroupLayout student_details_panelLayout = new javax.swing.GroupLayout(student_details_panel);
        student_details_panel.setLayout(student_details_panelLayout);
        student_details_panelLayout.setHorizontalGroup(
            student_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, student_details_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabel_scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        student_details_panelLayout.setVerticalGroup(
            student_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_details_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabel_scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout Student_search_panelLayout = new javax.swing.GroupLayout(Student_search_panel);
        Student_search_panel.setLayout(Student_search_panelLayout);
        Student_search_panelLayout.setHorizontalGroup(
            Student_search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Student_search_panelLayout.createSequentialGroup()
                .addGroup(Student_search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_student_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(student_details_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Student_search_panelLayout.setVerticalGroup(
            Student_search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Student_search_panelLayout.createSequentialGroup()
                .addComponent(search_student_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(student_details_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Teacher_teacher_view_tabPane.addTab("Student Details", Student_search_panel);

        javax.swing.GroupLayout search_tab_panelLayout = new javax.swing.GroupLayout(search_tab_panel);
        search_tab_panel.setLayout(search_tab_panelLayout);
        search_tab_panelLayout.setHorizontalGroup(
            search_tab_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 994, Short.MAX_VALUE)
        );
        search_tab_panelLayout.setVerticalGroup(
            search_tab_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        Teacher_teacher_view_tabPane.addTab("Student Statics", search_tab_panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Teacher_teacher_view_tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Teacher_teacher_view_tabPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fatherName_cheakBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherName_cheakBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fatherName_cheakBoxActionPerformed

    private void FatherOccupation_cheakBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FatherOccupation_cheakBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FatherOccupation_cheakBoxActionPerformed

    private void MotherName_CheakBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotherName_CheakBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MotherName_CheakBoxActionPerformed

    private void MotherOccupation_cheakBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotherOccupation_cheakBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MotherOccupation_cheakBoxActionPerformed

    private void Home_Address_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home_Address_CheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Home_Address_CheckBoxActionPerformed

    private void Contact_number_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Contact_number_CheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Contact_number_CheckBoxActionPerformed

    private void studentDetails_Search_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDetails_Search_BtnActionPerformed
            if(search_studentByComboBox.getSelectedIndex()== 1){
                //search by student name
                String searchWord = search_textField.getText();
                try {
                    student_details = StudentController.searchStudentByName(searchWord);
                    for(Student student : student_details){
                        student.setGuardianList(GuardianRelationshipController.getGuardians(student.getStudentId()));
                    }
                    displaySearchResults();//call the methord of display results that sorted from database.
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(teacher_student_view.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(search_studentByComboBox.getSelectedIndex()==2){
                //search by student index
                String searchWord = search_textField.getText();
                try {
                    student_details.add(StudentController.searchStudentById(searchWord));
                    for(Student student : student_details){
                        student.setGuardianList(GuardianRelationshipController.getGuardians(student.getStudentId()));
                    }
                    displaySearchResults();//call the methord of display results that sorted from database.
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(teacher_student_view.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Please select student search by criteria before search.", "Missing search critirea", JOptionPane.INFORMATION_MESSAGE);
            }
      
        
        
    }//GEN-LAST:event_studentDetails_Search_BtnActionPerformed

    private void search_studentByComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_studentByComboBoxKeyPressed
                
// TODO add your handling code here:
    }//GEN-LAST:event_search_studentByComboBoxKeyPressed

    private void search_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_textFieldActionPerformed

    private void search_textFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_textFieldMouseClicked
            if(search_studentByComboBox.getSelectedIndex()== 0){
                JOptionPane.showMessageDialog(null, "Please select student search by criteria before search.", "Missing search critirea", JOptionPane.INFORMATION_MESSAGE);
            }
        
// TODO add your handling code here:
    }//GEN-LAST:event_search_textFieldMouseClicked

    private void FatherTelephone_cheakBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FatherTelephone_cheakBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FatherTelephone_cheakBoxActionPerformed

    private void MotherTelephone_cheakBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotherTelephone_cheakBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MotherTelephone_cheakBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdvanceSearchTools_panel;
    private javax.swing.JCheckBox Contact_number_CheckBox;
    private javax.swing.JCheckBox FatherOccupation_cheakBox;
    private javax.swing.JCheckBox FatherTelephone_cheakBox;
    private javax.swing.JCheckBox Home_Address_CheckBox;
    private javax.swing.JCheckBox MotherName_CheakBox;
    private javax.swing.JCheckBox MotherOccupation_cheakBox;
    private javax.swing.JCheckBox MotherTelephone_cheakBox;
    private javax.swing.ButtonGroup Search_btn_group;
    private javax.swing.JRadioButton Search_inClass_RadioButton;
    private javax.swing.JRadioButton Search_inGrade_RadioButton;
    private javax.swing.JRadioButton Search_inSchool_RadioButton;
    private javax.swing.JPanel Student_search_panel;
    private javax.swing.JTabbedPane Teacher_teacher_view_tabPane;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox fatherName_cheakBox;
    private javax.swing.JButton getFullDetailsOfaStudent_button;
    private javax.swing.JCheckBox index_number_CheakBox;
    private javax.swing.JComboBox search_studentByComboBox;
    private javax.swing.JPanel search_student_panel;
    private javax.swing.JPanel search_tab_panel;
    private java.awt.TextField search_textField;
    private javax.swing.JButton studentDetails_Search_Btn;
    private javax.swing.JPanel student_details_panel;
    private javax.swing.JTable student_details_table;
    private javax.swing.JCheckBox student_name_CheckBox;
    private javax.swing.JScrollPane tabel_scrollPane;
    // End of variables declaration//GEN-END:variables

    
}
