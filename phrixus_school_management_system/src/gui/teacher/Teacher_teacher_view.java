
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.teacher;

import Controller.AcademicStaffController;
import Controller.AchievementController;
import Controller.ClassRoomController;
import Controller.EnrollmentController;
import Controller.SocietyController;
import Controller.StudentController;
import Controller.SubjectController;
import Controller.TermTestController;
import Model.AcademicMember;
import Model.Achievement;
import Model.ClassRoom;
import Model.Marks;
import Model.Society;
import Model.Student;
import Model.Subject;
import Model.TermTestResult;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.InflaterInputStream;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Lahiru Sandeepa
 */
public class Teacher_teacher_view extends javax.swing.JInternalFrame {
    JPanel achive_panel;
    ClassRoom teachers_classRoom;
    DefaultTableModel student_marks_table ;
    ArrayList<Marks> getStudentList; //student list for Enter student marks, UpdateMarks table
    
    /**
     * Creates new form teacher
     */
    public Teacher_teacher_view() {
        initComponents();
        init_Window_Components();
    }
    /*
        Lahiru Sandeepa
        This public void init_Window_Components() methord for setting form variables and information and data 
        to form when form set up im main window.mainly set teacher's informations in view Profile and tabs.
    */
    private void init_Window_Components(){
        int teacher_id = 130536;
        student_marks_table =  (DefaultTableModel) student_Mark_enter_table.getModel();
        
        try {
            //For Profile
            AcademicMember teacher = AcademicStaffController.searchTeacherById(teacher_id);
            //for Update marks
            teachers_classRoom = ClassRoomController.searchClassRoomby_TeacherID(teacher_id);
            ArrayList<Subject> subjectList = SubjectController.getSubjectList(teachers_classRoom.getGradeId());  
            //for Achivement Tab
            ArrayList<Achievement> AchievementList = AchievementController.getAchievementList_ByTeacherID(teacher_id);
            ArrayList<Society> Achievement_SocietyList = SocietyController.getAChievement_StudentList(AchievementList);
            ArrayList<Student> studentimageList = StudentController.getStudentImageList(AchievementList);

            
            setTextPrpfileView_Tab(teacher);
            setTextUpdateMarks_Tab(subjectList, teachers_classRoom);
            setTextStudentApproval_Tab(AchievementList, Achievement_SocietyList, studentimageList);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Teacher_teacher_view.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setTextPrpfileView_Tab(AcademicMember teacher){
        TeacherName_TextField.setText(teacher.getName());
        Register_number_TextField.setText(Integer.toString(teacher.getMemberId()));
        NIC_number_TextField.setText(teacher.getNic());
        try{
            Day_ComboBox.setSelectedItem(Integer.toString(teacher.getBirthday().getDay()));
            Month_ComboBox.setSelectedItem(Integer.toString(teacher.getBirthday().getMonth()));
            Year_comboBox.setSelectedItem(Integer.toString(teacher.getBirthday().getYear()));
        }catch(NullPointerException nullpointer){
            //when first time or not entered birthday
            Day_ComboBox.setSelectedIndex(0);
            Month_ComboBox.setSelectedIndex(0);
            Year_comboBox.setSelectedIndex(0);   
        }
        HomeAddress_TextArea.setText(teacher.getAddress());
        Telephone_TextField1.setText(Integer.toString(teacher.getTelephoneNo()));
        MobileNo_TextField2.setText(Integer.toString(teacher.getMobileNo()));
        Position_TextField.setText(teacher.getDesignation());
        ArrayList<Subject> subjectList = teacher.getSubjects();
        String ConcateSubjectList = "<html> ";
        for( Subject getSubj : subjectList){
            ConcateSubjectList = ConcateSubjectList.concat(getSubj.getName()+"  ");
        }
        ConcateSubjectList = ConcateSubjectList.concat("</html>  ");
        Subject_TextField.setText(ConcateSubjectList);
        email_TextField1.setText(teacher.getEmail());
        extra_TextArea1.setText(teacher.getExtra());
        Teacher_image_Label.setIcon((Icon) teacher.getImage());
    }
    private void setTextUpdateMarks_Tab(ArrayList<Subject> subjectList,ClassRoom classRoom) {
            grade_label.setText(Integer.toString(classRoom.getGradeId())); //set Grade 6,7,8....
            classRoom_label.setText(classRoom.getClassName()); //set class A,B,C.....
            int i =0;
            while(subjectList.isEmpty()){
                Select_subject_ComboBox.addItem(subjectList.get(i));
                i++;
            }
    }
    private void setTextStudentApproval_Tab(ArrayList<Achievement> AchievementList, ArrayList<Society> Achievement_SocietyList, ArrayList<Student> studentimageList){
        /*
        In this ethord basically i set achivement Details of each students related to this teacher, i get achivement list related with this teacher
        and All the student List and society list.
        then while loop, each achiement, identify student fro studentList and society list and get relavent details about that student to show 
        in achievement panel
        */
        
        setAchivement_Layout(AchievementList.size());// set new panel to display all achiement panels (methord)

        int index_counter = 0;
        while(AchievementList.isEmpty()){
            Achivement_panal newAchivemt = new Achivement_panal(); // create new panel for achievment
            newAchivemt.setAchivement(AchievementList.get(index_counter)); //set Achivemnt to panel as local variable
            newAchivemt.setDiscription(AchievementList.get(index_counter).getAchievement());// set achivemtent discription in panel Text Area
        
            int index_counter_student = 0;
            // find the correct student name, image and society name from ArrayList of them....
            while(studentimageList.isEmpty()){
                // find student details
                if(AchievementList.get(index_counter).getAchieverId()== studentimageList.get(index_counter_student).getStudentId()){
                    newAchivemt.setStudentName(studentimageList.get(index_counter_student).getFullName());// set student name into Label
                    newAchivemt.setstudentimage((Icon) studentimageList.get(index_counter_student).getPhotograph());
                    String Grade_Class = studentimageList.get(index_counter_student).getClassRoom().getGradeId() + " "+ studentimageList.get(index_counter_student).getClassRoom().getClassName();
                    newAchivemt.setGrade_Class(Grade_Class); // grade and Class set as "10 A" / " 9 B"
                }
                // find the Society Name
                if(AchievementList.get(index_counter).getSociety_id()== Achievement_SocietyList.get(index_counter_student).getId() ){
                    newAchivemt.setSocietyName(Achievement_SocietyList.get(index_counter_student).getName());// set society name
                }
                index_counter_student++;
            }
            index_counter++;
        
    }
    }
    private void setAchivement_Layout(int numberOf_achivements){
        this.achive_panel = new JPanel();
        this.achive_panel.setLayout(new GridLayout(numberOf_achivements, 0));
        achivement_scroll_panel.setViewportView(this.achive_panel);
    }
    
    public void getTextProfileView_Tab(){
        Date setDate = new Date();
        AcademicMember teacher = new AcademicMember();
        teacher.setName(TeacherName_TextField.getText());
        teacher.setMemberId(Integer.valueOf( Register_number_TextField.getText()));
        teacher.setNic(NIC_number_TextField.getText());      
        teacher.setAddress(HomeAddress_TextArea.getText());
        teacher.setTelephoneNo(Integer.valueOf(Telephone_TextField1.getText()));
        teacher.setMobileNo(Integer.valueOf(MobileNo_TextField2.getText()));
        teacher.setDesignation( Position_TextField.getText());
        teacher.setExtra(extra_TextArea1.getText());
        
        setDate.setDate((int)Day_ComboBox.getSelectedItem());
        setDate.setMonth((int) Month_ComboBox.getSelectedItem());
        setDate.setYear((int) Year_comboBox.getSelectedItem());
        teacher.setBirthday(setDate);
        teacher.setImage((InputStream) Teacher_image_Label.getIcon());
        try {
            AcademicStaffController.set_teacherUpdate(teacher);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Teacher_teacher_view.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void getTextStudentApproval_Tab(int student_id){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teacher_View_FileChooser = new javax.swing.JFileChooser();
        Teacher_Tab_pane = new javax.swing.JTabbedPane();
        T_Tab_ViewProfile = new javax.swing.JPanel();
        T_ViewPrfile_ImageBox_panel = new javax.swing.JPanel();
        Teacher_image_Label = new javax.swing.JLabel();
        Change_image_Btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ID_Number_Label1 = new javax.swing.JLabel();
        ID_Number_Label = new javax.swing.JLabel();
        NIC_number_TextField = new javax.swing.JTextField();
        Birthday_Label = new javax.swing.JLabel();
        Day_ComboBox = new javax.swing.JComboBox();
        Month_ComboBox = new javax.swing.JComboBox();
        Year_comboBox = new javax.swing.JComboBox();
        Home_Address_Label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        HomeAddress_TextArea = new javax.swing.JTextArea();
        Position_Label = new javax.swing.JLabel();
        Position_TextField = new javax.swing.JTextField();
        Subject_TextField = new javax.swing.JTextField();
        Extra_label = new javax.swing.JLabel();
        Subject_Label = new javax.swing.JLabel();
        TelePhone_Label1 = new javax.swing.JLabel();
        Telephone_TextField1 = new javax.swing.JTextField();
        MobileNo_Label2 = new javax.swing.JLabel();
        MobileNo_TextField2 = new javax.swing.JTextField();
        TeacherName_TextField = new javax.swing.JTextField();
        email_Label1 = new javax.swing.JLabel();
        email_TextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        extra_TextArea1 = new javax.swing.JTextArea();
        TeacherView_Edit_btn = new javax.swing.JButton();
        Register_number_TextField = new javax.swing.JTextField();
        subHeadLine_label1 = new javax.swing.JLabel();
        HeadLine_label1 = new javax.swing.JLabel();
        T_Tab_UpdateMarks = new javax.swing.JPanel();
        Update_marks_Selecting_panal = new javax.swing.JPanel();
        Select_subject_ComboBox = new javax.swing.JComboBox();
        Select_subject_LAbel = new javax.swing.JLabel();
        Select_class_LAbel1 = new javax.swing.JLabel();
        Select_Term_Label = new javax.swing.JLabel();
        Select_term_ComboBox = new javax.swing.JComboBox();
        search_studentList_EnterMarks = new javax.swing.JButton();
        grade_label = new javax.swing.JLabel();
        classRoom_label = new javax.swing.JLabel();
        StudentMarks_scrollPanel = new javax.swing.JScrollPane();
        student_Mark_enter_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        save_updateMarks_btn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Text_Name_BarPanel = new javax.swing.JPanel();
        HeadLine_label = new javax.swing.JLabel();
        subHeadLine_label = new javax.swing.JLabel();
        student_approval_Tab_panal = new javax.swing.JPanel();
        HeadLine_BarPanel = new javax.swing.JPanel();
        HeadLine_StudentApproval_label = new javax.swing.JLabel();
        subHeadLine_StudentApproval_label2 = new javax.swing.JLabel();
        achivement_scroll_panel = new javax.swing.JScrollPane();

        Teacher_image_Label.setBackground(new java.awt.Color(255, 255, 255));
        Teacher_image_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/teacher Profile.jpg"))); // NOI18N

        Change_image_Btn.setText("Change Image");
        Change_image_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Change_image_BtnActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        ID_Number_Label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ID_Number_Label1.setText("Register No      :");

        ID_Number_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ID_Number_Label.setText("NIC Number      :");

        NIC_number_TextField.setEditable(false);

        Birthday_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Birthday_Label.setText("Birth-Day          :");

        Day_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        Month_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month..", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        Year_comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year...", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950" }));

        Home_Address_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Home_Address_Label.setText("Home Address :");

        HomeAddress_TextArea.setEditable(false);
        HomeAddress_TextArea.setColumns(20);
        HomeAddress_TextArea.setRows(5);
        jScrollPane2.setViewportView(HomeAddress_TextArea);

        Position_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Position_Label.setText("Position             :");

        Position_TextField.setEditable(false);

        Subject_TextField.setEditable(false);

        Extra_label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Extra_label.setText("Extra                  :");

        Subject_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Subject_Label.setText("Subjects            :");

        TelePhone_Label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TelePhone_Label1.setText("TelePhone        :");

        Telephone_TextField1.setEditable(false);

        MobileNo_Label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        MobileNo_Label2.setText("Mobile No.        :");

        MobileNo_TextField2.setEditable(false);

        TeacherName_TextField.setEditable(false);
        TeacherName_TextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TeacherName_TextField.setText("NAME OF THE TEACHER");

        email_Label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        email_Label1.setText("Email                 :");

        email_TextField1.setEditable(false);

        extra_TextArea1.setEditable(false);
        extra_TextArea1.setColumns(20);
        extra_TextArea1.setRows(5);
        jScrollPane3.setViewportView(extra_TextArea1);

        TeacherView_Edit_btn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TeacherView_Edit_btn.setText("Edit");
        TeacherView_Edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherView_Edit_btnActionPerformed(evt);
            }
        });

        Register_number_TextField.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(ID_Number_Label1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Register_number_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(ID_Number_Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(NIC_number_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Home_Address_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TelePhone_Label1)
                                            .addComponent(MobileNo_Label2))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Telephone_TextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(MobileNo_TextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                                .addGap(70, 70, 70)))
                        .addGap(75, 75, 75))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Extra_label, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(email_Label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(email_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Position_Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Position_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Subject_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Subject_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Birthday_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Day_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Month_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Year_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TeacherName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TeacherView_Edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(TeacherView_Edit_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TeacherName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_Number_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Register_number_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_Number_Label)
                    .addComponent(NIC_number_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Birthday_Label)
                    .addComponent(Day_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Month_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Year_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Home_Address_Label)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelePhone_Label1)
                    .addComponent(Telephone_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MobileNo_Label2)
                    .addComponent(MobileNo_TextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_Label1)
                    .addComponent(email_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Position_Label)
                    .addComponent(Position_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Subject_Label)
                    .addComponent(Subject_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Extra_label)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        subHeadLine_label1.setText("Personal details about you, Allow Edit and view");

        HeadLine_label1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        HeadLine_label1.setForeground(new java.awt.Color(51, 51, 255));
        HeadLine_label1.setText("My Profile");

        javax.swing.GroupLayout T_ViewPrfile_ImageBox_panelLayout = new javax.swing.GroupLayout(T_ViewPrfile_ImageBox_panel);
        T_ViewPrfile_ImageBox_panel.setLayout(T_ViewPrfile_ImageBox_panelLayout);
        T_ViewPrfile_ImageBox_panelLayout.setHorizontalGroup(
            T_ViewPrfile_ImageBox_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(T_ViewPrfile_ImageBox_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(T_ViewPrfile_ImageBox_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(T_ViewPrfile_ImageBox_panelLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(HeadLine_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_ViewPrfile_ImageBox_panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(T_ViewPrfile_ImageBox_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_ViewPrfile_ImageBox_panelLayout.createSequentialGroup()
                                .addComponent(subHeadLine_label1)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_ViewPrfile_ImageBox_panelLayout.createSequentialGroup()
                                .addGroup(T_ViewPrfile_ImageBox_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Teacher_image_Label)
                                    .addComponent(Change_image_Btn))
                                .addGap(46, 46, 46))))))
        );
        T_ViewPrfile_ImageBox_panelLayout.setVerticalGroup(
            T_ViewPrfile_ImageBox_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, T_ViewPrfile_ImageBox_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(HeadLine_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subHeadLine_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(Teacher_image_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Change_image_Btn)
                .addGap(109, 109, 109))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, T_ViewPrfile_ImageBox_panelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout T_Tab_ViewProfileLayout = new javax.swing.GroupLayout(T_Tab_ViewProfile);
        T_Tab_ViewProfile.setLayout(T_Tab_ViewProfileLayout);
        T_Tab_ViewProfileLayout.setHorizontalGroup(
            T_Tab_ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(T_ViewPrfile_ImageBox_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        T_Tab_ViewProfileLayout.setVerticalGroup(
            T_Tab_ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(T_Tab_ViewProfileLayout.createSequentialGroup()
                .addComponent(T_ViewPrfile_ImageBox_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Teacher_Tab_pane.addTab("View Profile", T_Tab_ViewProfile);

        Update_marks_Selecting_panal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Class Selection Box", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        Select_subject_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_subject_ComboBoxActionPerformed(evt);
            }
        });

        Select_subject_LAbel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Select_subject_LAbel.setText("Select the Subject :");

        Select_class_LAbel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Select_class_LAbel1.setText("Select the Grade and Class room :");

        Select_Term_Label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Select_Term_Label.setText("Select the term :");

        Select_term_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1st Term", "2nd Term", "3rd Term" }));
        Select_term_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_term_ComboBoxActionPerformed(evt);
            }
        });

        search_studentList_EnterMarks.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        search_studentList_EnterMarks.setText("Search");
        search_studentList_EnterMarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_studentList_EnterMarksActionPerformed(evt);
            }
        });

        grade_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        grade_label.setForeground(new java.awt.Color(0, 51, 255));
        grade_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        grade_label.setText("9");

        classRoom_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        classRoom_label.setForeground(new java.awt.Color(0, 51, 255));
        classRoom_label.setText("D");

        javax.swing.GroupLayout Update_marks_Selecting_panalLayout = new javax.swing.GroupLayout(Update_marks_Selecting_panal);
        Update_marks_Selecting_panal.setLayout(Update_marks_Selecting_panalLayout);
        Update_marks_Selecting_panalLayout.setHorizontalGroup(
            Update_marks_Selecting_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Update_marks_Selecting_panalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(Update_marks_Selecting_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Update_marks_Selecting_panalLayout.createSequentialGroup()
                        .addComponent(Select_class_LAbel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grade_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classRoom_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(Select_Term_Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Select_term_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Update_marks_Selecting_panalLayout.createSequentialGroup()
                        .addComponent(Select_subject_LAbel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Select_subject_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(search_studentList_EnterMarks)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        Update_marks_Selecting_panalLayout.setVerticalGroup(
            Update_marks_Selecting_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Update_marks_Selecting_panalLayout.createSequentialGroup()
                .addGroup(Update_marks_Selecting_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Update_marks_Selecting_panalLayout.createSequentialGroup()
                        .addGroup(Update_marks_Selecting_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Select_subject_LAbel)
                            .addComponent(Select_subject_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Update_marks_Selecting_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Update_marks_Selecting_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Select_class_LAbel1)
                                .addComponent(grade_label)
                                .addComponent(classRoom_label, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Select_Term_Label))
                            .addComponent(Select_term_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(search_studentList_EnterMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        student_Mark_enter_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Index No", "Student Name", "Marks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        student_Mark_enter_table.setRowSelectionAllowed(false);
        StudentMarks_scrollPanel.setViewportView(student_Mark_enter_table);
        if (student_Mark_enter_table.getColumnModel().getColumnCount() > 0) {
            student_Mark_enter_table.getColumnModel().getColumn(0).setMinWidth(150);
            student_Mark_enter_table.getColumnModel().getColumn(0).setPreferredWidth(150);
            student_Mark_enter_table.getColumnModel().getColumn(0).setMaxWidth(150);
            student_Mark_enter_table.getColumnModel().getColumn(1).setMinWidth(400);
            student_Mark_enter_table.getColumnModel().getColumn(1).setPreferredWidth(400);
            student_Mark_enter_table.getColumnModel().getColumn(1).setMaxWidth(400);
            student_Mark_enter_table.getColumnModel().getColumn(2).setMinWidth(150);
            student_Mark_enter_table.getColumnModel().getColumn(2).setPreferredWidth(150);
            student_Mark_enter_table.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        save_updateMarks_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        save_updateMarks_btn.setText("Save");
        save_updateMarks_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_updateMarks_btnActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(java.awt.SystemColor.controlHighlight);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Instructuctions:\n\nYou can Enter student marks\nonly for your class room.\nyou must enter all the subjects\nresults of students in the \nclass in there.\n\nselect the \"Subject\" and \"term\"\nand then press Search.\nEnter marks...\nthen you must press \"SAVE\" to \nsave results.\n\n");
        jTextArea1.setToolTipText("");
        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(save_updateMarks_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(save_updateMarks_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        HeadLine_label.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        HeadLine_label.setForeground(new java.awt.Color(51, 51, 255));
        HeadLine_label.setText("Update Student Marks");

        subHeadLine_label.setText("Allow to Enter subject marks on term test of student of the Class");

        javax.swing.GroupLayout Text_Name_BarPanelLayout = new javax.swing.GroupLayout(Text_Name_BarPanel);
        Text_Name_BarPanel.setLayout(Text_Name_BarPanelLayout);
        Text_Name_BarPanelLayout.setHorizontalGroup(
            Text_Name_BarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Text_Name_BarPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Text_Name_BarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Text_Name_BarPanelLayout.createSequentialGroup()
                        .addComponent(HeadLine_label, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Text_Name_BarPanelLayout.createSequentialGroup()
                        .addComponent(subHeadLine_label)
                        .addGap(100, 100, 100))))
        );
        Text_Name_BarPanelLayout.setVerticalGroup(
            Text_Name_BarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Text_Name_BarPanelLayout.createSequentialGroup()
                .addComponent(HeadLine_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subHeadLine_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout T_Tab_UpdateMarksLayout = new javax.swing.GroupLayout(T_Tab_UpdateMarks);
        T_Tab_UpdateMarks.setLayout(T_Tab_UpdateMarksLayout);
        T_Tab_UpdateMarksLayout.setHorizontalGroup(
            T_Tab_UpdateMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_Tab_UpdateMarksLayout.createSequentialGroup()
                .addComponent(Text_Name_BarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_Tab_UpdateMarksLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(T_Tab_UpdateMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Update_marks_Selecting_panal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentMarks_scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        T_Tab_UpdateMarksLayout.setVerticalGroup(
            T_Tab_UpdateMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_Tab_UpdateMarksLayout.createSequentialGroup()
                .addComponent(Text_Name_BarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(T_Tab_UpdateMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(T_Tab_UpdateMarksLayout.createSequentialGroup()
                        .addComponent(Update_marks_Selecting_panal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(StudentMarks_scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Teacher_Tab_pane.addTab("Update Marks", T_Tab_UpdateMarks);

        HeadLine_StudentApproval_label.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        HeadLine_StudentApproval_label.setForeground(new java.awt.Color(51, 51, 255));
        HeadLine_StudentApproval_label.setText("student achievment approval");

        subHeadLine_StudentApproval_label2.setText("Authority of approval of student Achivements and winners");

        javax.swing.GroupLayout HeadLine_BarPanelLayout = new javax.swing.GroupLayout(HeadLine_BarPanel);
        HeadLine_BarPanel.setLayout(HeadLine_BarPanelLayout);
        HeadLine_BarPanelLayout.setHorizontalGroup(
            HeadLine_BarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadLine_BarPanelLayout.createSequentialGroup()
                .addContainerGap(483, Short.MAX_VALUE)
                .addGroup(HeadLine_BarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeadLine_BarPanelLayout.createSequentialGroup()
                        .addComponent(HeadLine_StudentApproval_label, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeadLine_BarPanelLayout.createSequentialGroup()
                        .addComponent(subHeadLine_StudentApproval_label2)
                        .addGap(98, 98, 98))))
        );
        HeadLine_BarPanelLayout.setVerticalGroup(
            HeadLine_BarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadLine_BarPanelLayout.createSequentialGroup()
                .addComponent(HeadLine_StudentApproval_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subHeadLine_StudentApproval_label2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout student_approval_Tab_panalLayout = new javax.swing.GroupLayout(student_approval_Tab_panal);
        student_approval_Tab_panal.setLayout(student_approval_Tab_panalLayout);
        student_approval_Tab_panalLayout.setHorizontalGroup(
            student_approval_Tab_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeadLine_BarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(achivement_scroll_panel)
        );
        student_approval_Tab_panalLayout.setVerticalGroup(
            student_approval_Tab_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_approval_Tab_panalLayout.createSequentialGroup()
                .addComponent(HeadLine_BarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(achivement_scroll_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
        );

        Teacher_Tab_pane.addTab("Student Approvals", student_approval_Tab_panal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Teacher_Tab_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Teacher_Tab_pane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Change_image_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Change_image_BtnActionPerformed
   //teacher Profile View Tab
//<<<<<<< HEAD
        BufferedImage image = null;
        if(teacher_View_FileChooser.showOpenDialog(this)== JFileChooser.APPROVE_OPTION){
            //get selected file path
            File imagefile = teacher_View_FileChooser.getSelectedFile();
            try { 
                image = ImageIO.read(imagefile);
            } catch (IOException ex) {
                Logger.getLogger(Teacher_teacher_view.class.getName()).log(Level.SEVERE, null, ex);
//=======
       FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg"); // ONly jpg,jpge files filter and open
         teacher_View_FileChooser.setFileFilter(filter);
         try {
            if(teacher_View_FileChooser.showOpenDialog(this)== JFileChooser.APPROVE_OPTION){
                //get selected file path
                imagefile = teacher_View_FileChooser.getSelectedFile();
                String getImagePAth = teacher_View_FileChooser.getSelectedFile().getPath();
                ImageIcon icon=  new ImageIcon(getImagePAth);
              //  BufferedImage dimg = (BufferedImage) image.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), image.SCALE_SMOOTH);
                Teacher_image_Label.setIcon(icon);
            }else {
                            JOptionPane.showMessageDialog(null, "Feel Free to Look Later");
//>>>>>>> origin/master
            }
        } catch (Exception e) {
        }
            }
        }
    }//GEN-LAST:event_Change_image_BtnActionPerformed

    private void save_updateMarks_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_updateMarks_btnActionPerformed
        int currantRow =0; // loop iterator
        int noOfMarksEntered = 0; // parity bit of check all the students were get marks on the list
        while(student_marks_table.getRowCount() <= currantRow){
            //check again  marks enter for correct student
                if(getStudentList.get(currantRow).getStudent_id() == (int)student_marks_table.getValueAt(currantRow, 0)){
                    getStudentList.get(currantRow).setMarks((int)student_marks_table.getValueAt(currantRow, 2));
                    getStudentList.get(currantRow).setTerm(Select_term_ComboBox.getSelectedIndex());
                    
                    noOfMarksEntered++;
                }
                currantRow++;

        }
        if(currantRow == noOfMarksEntered){
            try {
                //passed into the database
                TermTestController.setStudent_UpdateMarks(getStudentList);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Teacher_teacher_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
                JOptionPane.showMessageDialog(null, "You haven't put marks on every students. check again and enter marks for every ", "Error: Not every marks Entered",JOptionPane.ERROR_MESSAGE);
           
        }
      
       // EnrollmentController.updateStudentMarks(studentMarks);// passed the all date 1
    }//GEN-LAST:event_save_updateMarks_btnActionPerformed

    private void TeacherView_Edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherView_Edit_btnActionPerformed
        if(TeacherView_Edit_btn.getText().equalsIgnoreCase("Edit")){
            TeacherName_TextField.setEditable(true);
            HomeAddress_TextArea.setEditable(true);
            Telephone_TextField1.setEditable(true);
            MobileNo_TextField2.setEditable(true);
            email_TextField1.setEditable(true);
            Position_TextField.setEditable(true);
          
            extra_TextArea1.setEditable(true);
            Year_comboBox.setEditable(true);
            Month_ComboBox.setEditable(true);
            Day_ComboBox.setEditable(true);
            TeacherView_Edit_btn.setText("OK");
        }else{
            TeacherName_TextField.setEditable(false);
            NIC_number_TextField.setEditable(false);
            HomeAddress_TextArea.setEditable(false);
            Telephone_TextField1.setEditable(false);
            MobileNo_TextField2.setEditable(false);
            email_TextField1.setEditable(false);
            Position_TextField.setEditable(false);
            Subject_TextField.setEditable(false);
            Register_number_TextField.setEditable(false);
            extra_TextArea1.setEditable(false);
            Year_comboBox.setEditable(false);
            Month_ComboBox.setEditable(false);
            Day_ComboBox.setEditable(true);
            TeacherView_Edit_btn.setText("Edit");
            getTextProfileView_Tab();            
        }


    }//GEN-LAST:event_TeacherView_Edit_btnActionPerformed

    private void search_studentList_EnterMarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_studentList_EnterMarksActionPerformed
        
        if(Select_term_ComboBox.getSelectedIndex()== 0 || Select_subject_ComboBox.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Please Select Term and Subject Before Load the student List", "Error on select Term or subject",JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                //get all the students in the Class
                ArrayList<Student> studentList = StudentController.getStudentList_InClass(teachers_classRoom.getClassId());
                int subject_id = SubjectController.getsubjectId((String) Select_subject_ComboBox.getSelectedItem());
                //passed All student list, to EnrollmenetController and Check with subject, whether that student Enroll into that subject and return student list who enroll to that subject
                getStudentList = EnrollmentController.getEnrollStudentList(studentList, subject_id);

                for(Marks studentmark: getStudentList){
                    //fill the Table with name list of student who doing that subject
                    String[] tempArray = {Integer.toString(studentmark.getStudent_id()),studentmark.getStudent_name(),"" };
                    student_marks_table.addRow(tempArray);
                    
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Teacher_teacher_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_search_studentList_EnterMarksActionPerformed

    private void Select_subject_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_subject_ComboBoxActionPerformed
            if(Select_subject_ComboBox.getSelectedIndex()== 0){
                JOptionPane.showMessageDialog(null,"You didn't enter subject correctly. please choose again", "Choose Subject   ", JOptionPane.ERROR_MESSAGE);
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_Select_subject_ComboBoxActionPerformed

    private void Select_term_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_term_ComboBoxActionPerformed
            if(Select_term_ComboBox.getSelectedIndex()== 0){
                JOptionPane.showMessageDialog(null,"You didn't enter Exam term correctly. please choose again", "Choose Exam term   ", JOptionPane.ERROR_MESSAGE);
            }    }//GEN-LAST:event_Select_term_ComboBoxActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Birthday_Label;
    private javax.swing.JButton Change_image_Btn;
    private javax.swing.JComboBox Day_ComboBox;
    private javax.swing.JLabel Extra_label;
    private javax.swing.JPanel HeadLine_BarPanel;
    private javax.swing.JLabel HeadLine_StudentApproval_label;
    private javax.swing.JLabel HeadLine_label;
    private javax.swing.JLabel HeadLine_label1;
    private javax.swing.JTextArea HomeAddress_TextArea;
    private javax.swing.JLabel Home_Address_Label;
    private javax.swing.JLabel ID_Number_Label;
    private javax.swing.JLabel ID_Number_Label1;
    private javax.swing.JLabel MobileNo_Label2;
    private javax.swing.JTextField MobileNo_TextField2;
    private javax.swing.JComboBox Month_ComboBox;
    private javax.swing.JTextField NIC_number_TextField;
    private javax.swing.JLabel Position_Label;
    private javax.swing.JTextField Position_TextField;
    private javax.swing.JTextField Register_number_TextField;
    private javax.swing.JLabel Select_Term_Label;
    private javax.swing.JLabel Select_class_LAbel1;
    private javax.swing.JComboBox Select_subject_ComboBox;
    private javax.swing.JLabel Select_subject_LAbel;
    private javax.swing.JComboBox Select_term_ComboBox;
    private javax.swing.JScrollPane StudentMarks_scrollPanel;
    private javax.swing.JLabel Subject_Label;
    private javax.swing.JTextField Subject_TextField;
    private javax.swing.JPanel T_Tab_UpdateMarks;
    private javax.swing.JPanel T_Tab_ViewProfile;
    private javax.swing.JPanel T_ViewPrfile_ImageBox_panel;
    private javax.swing.JTextField TeacherName_TextField;
    private javax.swing.JButton TeacherView_Edit_btn;
    private javax.swing.JTabbedPane Teacher_Tab_pane;
    private javax.swing.JLabel Teacher_image_Label;
    private javax.swing.JLabel TelePhone_Label1;
    private javax.swing.JTextField Telephone_TextField1;
    private javax.swing.JPanel Text_Name_BarPanel;
    private javax.swing.JPanel Update_marks_Selecting_panal;
    private javax.swing.JComboBox Year_comboBox;
    private javax.swing.JScrollPane achivement_scroll_panel;
    private javax.swing.JLabel classRoom_label;
    private javax.swing.JLabel email_Label1;
    private javax.swing.JTextField email_TextField1;
    private javax.swing.JTextArea extra_TextArea1;
    private javax.swing.JLabel grade_label;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton save_updateMarks_btn;
    private javax.swing.JButton search_studentList_EnterMarks;
    private javax.swing.JTable student_Mark_enter_table;
    private javax.swing.JPanel student_approval_Tab_panal;
    private javax.swing.JLabel subHeadLine_StudentApproval_label2;
    private javax.swing.JLabel subHeadLine_label;
    private javax.swing.JLabel subHeadLine_label1;
    private javax.swing.JFileChooser teacher_View_FileChooser;
    // End of variables declaration//GEN-END:variables

    
}
