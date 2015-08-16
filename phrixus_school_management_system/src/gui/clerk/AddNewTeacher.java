/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.clerk;

import Controller.SubjectController;
import Model.Subject;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author hp pc
 */
public class AddNewTeacher extends javax.swing.JInternalFrame {
       JDesktopPane desktopPane;
       BufferedImage image = null;
       DefaultComboBoxModel comboBoxModel;
       DefaultListModel listModel=new DefaultListModel();
       
    /**
     * Creates new form AddNewTeacher
     */
    public AddNewTeacher(JDesktopPane desktopPane) {
        this.desktopIcon=desktopIcon;
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        loadSubjects();
        subjectList.setModel(listModel);
        subjectCombo.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<listModel.getSize(); i++){
                    if(listModel.get(i).equals(subjectCombo.getSelectedItem())){
                        listModel.remove(i);
                        break;
                    }
                }                
                listModel.addElement(subjectCombo.getSelectedItem());
            }
        });
    }
    
    public void loadSubjects(){
           try {
               ArrayList<Subject> subjectList=SubjectController.getAllSubjects();
               comboBoxModel=(DefaultComboBoxModel) subjectCombo.getModel();
               for(Subject subject : subjectList){
                   comboBoxModel.addElement(subject.getName()+" Grade "+subject.getGrade());
               }
               
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AddNewTeacher.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(AddNewTeacher.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Teacher_image_Label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ID_Number_Label1 = new javax.swing.JLabel();
        ID_Number_Label = new javax.swing.JLabel();
        NIC_number_TextField = new javax.swing.JTextField();
        Birthday_Label = new javax.swing.JLabel();
        Home_Address_Label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        homeAddress_TextArea = new javax.swing.JTextArea();
        Position_Label = new javax.swing.JLabel();
        Extra_label = new javax.swing.JLabel();
        TelePhone_Label1 = new javax.swing.JLabel();
        telephone_TextField = new javax.swing.JTextField();
        MobileNo_Label2 = new javax.swing.JLabel();
        mobileNo_TextField = new javax.swing.JTextField();
        email_Label1 = new javax.swing.JLabel();
        email_TextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        extra_TextArea1 = new javax.swing.JTextArea();
        register_number_TextField = new javax.swing.JTextField();
        birthDayChooser = new datechooser.beans.DateChooserCombo();
        ID_Number_Label2 = new javax.swing.JLabel();
        name_TextField = new javax.swing.JTextField();
        HeadLine_label1 = new javax.swing.JLabel();
        positionCombo = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        imageLbl = new javax.swing.JLabel();
        Change_image_Btn = new javax.swing.JButton();
        Subject_Label = new javax.swing.JLabel();
        subjectCombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectList = new javax.swing.JList();
        removeSubjectBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBorder(null);

        Teacher_image_Label.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        ID_Number_Label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ID_Number_Label1.setText("Register No      :");

        ID_Number_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ID_Number_Label.setText("NIC Number      :");

        Birthday_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Birthday_Label.setText("Birth-Day          :");

        Home_Address_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Home_Address_Label.setText("Home Address :");

        homeAddress_TextArea.setColumns(20);
        homeAddress_TextArea.setRows(5);
        jScrollPane2.setViewportView(homeAddress_TextArea);

        Position_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Position_Label.setText("Position             :");

        Extra_label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Extra_label.setText("Extra                  :");

        TelePhone_Label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TelePhone_Label1.setText("TelePhone        :");

        MobileNo_Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        MobileNo_Label2.setText("Mobile No.        :");

        email_Label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        email_Label1.setText("Email                 :");

        extra_TextArea1.setColumns(20);
        extra_TextArea1.setRows(5);
        jScrollPane3.setViewportView(extra_TextArea1);

        register_number_TextField.setEditable(false);

        ID_Number_Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ID_Number_Label2.setText("Name                 :");

        HeadLine_label1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        HeadLine_label1.setForeground(new java.awt.Color(51, 51, 255));
        HeadLine_label1.setText("Teacher Details");

        positionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Teacher", "Grade Head", "Sectional Head", "Deputy Principal", "Principal" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Extra_label, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Position_Label))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(positionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TelePhone_Label1)
                            .addComponent(MobileNo_Label2)
                            .addComponent(email_Label1)
                            .addComponent(Home_Address_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(telephone_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mobileNo_TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(email_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID_Number_Label2)
                            .addComponent(ID_Number_Label1)
                            .addComponent(ID_Number_Label)
                            .addComponent(Birthday_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(register_number_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birthDayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NIC_number_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(HeadLine_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeadLine_label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_Number_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_Number_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(register_number_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_Number_Label)
                    .addComponent(NIC_number_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(birthDayChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(Birthday_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Home_Address_Label)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelePhone_Label1)
                    .addComponent(telephone_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MobileNo_Label2)
                    .addComponent(mobileNo_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_Label1)
                    .addComponent(email_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Position_Label)
                    .addComponent(positionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Extra_label)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        imageLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Change_image_Btn.setText(" Photogragh");
        Change_image_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Change_image_BtnActionPerformed(evt);
            }
        });

        Subject_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Subject_Label.setText("Subjects            :");

        subjectCombo.setEditable(true);
        subjectCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                subjectComboItemStateChanged(evt);
            }
        });

        subjectList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(subjectList);

        removeSubjectBtn.setText("Remove");
        removeSubjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSubjectBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Subject_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(subjectCombo, 0, 190, Short.MAX_VALUE)
                            .addComponent(imageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Change_image_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeSubjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Change_image_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Subject_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeSubjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(1155, Short.MAX_VALUE)
                    .addComponent(Teacher_image_Label)
                    .addGap(221, 221, 221)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(483, Short.MAX_VALUE)
                    .addComponent(Teacher_image_Label)
                    .addGap(145, 145, 145)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Change_image_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Change_image_BtnActionPerformed
           try {
               JFileChooser fc=new JFileChooser();
               fc.showOpenDialog(null);
               File f=fc.getSelectedFile();  
               image = ImageIO.read(f);
               Image dimage=image.getScaledInstance(imageLbl.getWidth(), imageLbl.getHeight()-20,Image.SCALE_SMOOTH);
               imageLbl.setIcon(new ImageIcon(dimage));
           } catch (IOException ex) {
               JOptionPane.showMessageDialog(null, "Invalid File");
           }
        
    }//GEN-LAST:event_Change_image_BtnActionPerformed

    private void subjectComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_subjectComboItemStateChanged
            
    }//GEN-LAST:event_subjectComboItemStateChanged

    private void removeSubjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSubjectBtnActionPerformed
        int selectedIndex=subjectList.getSelectedIndex();
        if(selectedIndex>=0){
            listModel.removeElementAt(selectedIndex);
        }        
    }//GEN-LAST:event_removeSubjectBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Birthday_Label;
    private javax.swing.JButton Change_image_Btn;
    private javax.swing.JLabel Extra_label;
    private javax.swing.JLabel HeadLine_label1;
    private javax.swing.JLabel Home_Address_Label;
    private javax.swing.JLabel ID_Number_Label;
    private javax.swing.JLabel ID_Number_Label1;
    private javax.swing.JLabel ID_Number_Label2;
    private javax.swing.JLabel MobileNo_Label2;
    private javax.swing.JTextField NIC_number_TextField;
    private javax.swing.JLabel Position_Label;
    private javax.swing.JLabel Subject_Label;
    private javax.swing.JLabel Teacher_image_Label;
    private javax.swing.JLabel TelePhone_Label1;
    private datechooser.beans.DateChooserCombo birthDayChooser;
    private javax.swing.JLabel email_Label1;
    private javax.swing.JTextField email_TextField;
    private javax.swing.JTextArea extra_TextArea1;
    private javax.swing.JTextArea homeAddress_TextArea;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField mobileNo_TextField;
    private javax.swing.JTextField name_TextField;
    private javax.swing.JComboBox positionCombo;
    private javax.swing.JTextField register_number_TextField;
    private javax.swing.JButton removeSubjectBtn;
    private javax.swing.JComboBox subjectCombo;
    private javax.swing.JList subjectList;
    private javax.swing.JTextField telephone_TextField;
    // End of variables declaration//GEN-END:variables
}