/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.teacher;

import Controller.ClassRoomController;
import Controller.PeriodController;
import Controller.TimeTableController;
import Model.ClassRoom;
import Model.Period;
import Model.TimeTable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lahiru Sandeepa
 */
public class Teacher_TimeTable_View extends javax.swing.JInternalFrame {

    /**
     * Creates new form Teacher_TimeTable_View
     */
    public Teacher_TimeTable_View() {
        initComponents();
        init_TimeTable_Components();
    }
    
    private void init_TimeTable_Components(){
        try {
            ArrayList<TimeTable>timeslots = TimeTableController.getTimeTable_of_Teacher(3165);
            int count = 0;
            while(timeslots.isEmpty()){
                
                select_day_timetable(timeslots.get(count));
                count++;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Teacher_TimeTable_View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* This methord for selecting the day which is monday, tuesday... when given timeslot
    called in: init_TimeTable_Components();
    */
    private void select_day_timetable(TimeTable timeSlot){
        try {
            Period period = PeriodController.getTimeSlot(timeSlot.getPeriod_id());
            ClassRoom classroom = ClassRoomController.searchClassRoomByID(timeSlot.getClass_id());
            
            if(period.getDay().equalsIgnoreCase("monday")){
                set_monday(classroom,period);
            }
            else if(period.getDay().equalsIgnoreCase("tuesday")){
                set_tuesday(classroom,period);
            }else if(period.getDay().equalsIgnoreCase("wednday")){
                set_wednday(classroom,period);
            }else if(period.getDay().equalsIgnoreCase("thusday")){
                set_thusday(classroom,period);
            }else if(period.getDay().equalsIgnoreCase("friday")){
                set_friday(classroom,period);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Teacher_TimeTable_View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*For when day is select, choose the which period 1- 8*/
    private void set_monday(ClassRoom classroom, Period period){
        switch(period.getSubjectId()){
            case 1 : Mon_1_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 2 : Mon_2_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 3 : Mon_3_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 4 : Mon_4_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 5 : Mon_5_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 6 : Mon_6_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 7 : Mon_7_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 8 : Mon_8_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            
        }
    }
    private void set_tuesday(ClassRoom classroom, Period period){
        switch(period.getSubjectId()){
            case 1 : Tue_1_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 2 : Tue_2_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 3 : Tue_3_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 4 : Tue_4_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 5 : Tue_5_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 6 : Tue_6_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 7 : Tue_7_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 8 : Tue_8_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            
        }
    }
    private void set_wednday(ClassRoom classroom, Period period){
        switch(period.getSubjectId()){
            case 1 : Wen_1_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 2 : Wen_2_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 3 : Wen_3_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 4 : Wen_4_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 5 : Wen_5_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 6 : Wen_6_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 7 : Wen_7_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 8 : Wen_8_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            
        }
    }
    private void set_thusday(ClassRoom classroom, Period period){
        switch(period.getSubjectId()){
            case 1 : Thu_1_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 2 : Thu_2_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 3 : Thu_3_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 4 : Thu_4_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 5 : Thu_5_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 6 : Thu_6_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 7 : Thu_7_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 8 : Thu_8_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            
        }
    }
    private void set_friday(ClassRoom classroom, Period period){
        switch(period.getSubjectId()){
            case 1 : Fri_1_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 2 : Fri_2_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 3 : Fri_3_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 4 : Fri_4_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 5 : Fri_5_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 6 : Fri_6_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 7 : Fri_7_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            case 8 : Fri_8_label.setText("<html>"+classroom.getGradeId()+"-"+classroom.getClassName()+"</html>");break;
            
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

        TimeSlot4_label = new javax.swing.JLabel();
        TimeSlot8_label = new javax.swing.JLabel();
        TimeSlot5_label = new javax.swing.JLabel();
        TimeSlot6_label = new javax.swing.JLabel();
        TimeSlot1_Label = new javax.swing.JLabel();
        TimeSlot2_label = new javax.swing.JLabel();
        TimeSlot_label = new javax.swing.JLabel();
        TimeSlot7_label = new javax.swing.JLabel();
        Mon_1_label = new javax.swing.JLabel();
        Mon_2_label = new javax.swing.JLabel();
        Mon_3_label = new javax.swing.JLabel();
        Mon_4_label = new javax.swing.JLabel();
        Mon_5_label = new javax.swing.JLabel();
        Mon_6_label = new javax.swing.JLabel();
        Mon_7_label = new javax.swing.JLabel();
        Mon_8_label = new javax.swing.JLabel();
        Tue_1_label = new javax.swing.JLabel();
        Tue_2_label = new javax.swing.JLabel();
        Tue_3_label = new javax.swing.JLabel();
        Tue_4_label = new javax.swing.JLabel();
        Tue_5_label = new javax.swing.JLabel();
        Tue_6_label = new javax.swing.JLabel();
        Tue_7_label = new javax.swing.JLabel();
        Tue_8_label = new javax.swing.JLabel();
        Wen_3_label = new javax.swing.JLabel();
        Wen_4_label = new javax.swing.JLabel();
        Wen_1_label = new javax.swing.JLabel();
        Wen_7_label = new javax.swing.JLabel();
        Wen_2_label = new javax.swing.JLabel();
        Wen_8_label = new javax.swing.JLabel();
        Wen_6_label = new javax.swing.JLabel();
        Wen_5_label = new javax.swing.JLabel();
        Thu_1_label = new javax.swing.JLabel();
        Fri_1_label = new javax.swing.JLabel();
        Thu_2_label = new javax.swing.JLabel();
        Fri_2_label = new javax.swing.JLabel();
        Thu_3_label = new javax.swing.JLabel();
        Fri_3_label = new javax.swing.JLabel();
        Thu_4_label = new javax.swing.JLabel();
        Fri_4_label = new javax.swing.JLabel();
        Thu_5_label = new javax.swing.JLabel();
        Fri_5_label = new javax.swing.JLabel();
        Thu_6_label = new javax.swing.JLabel();
        Fri_6_label = new javax.swing.JLabel();
        Thu_7_label = new javax.swing.JLabel();
        Fri_7_label = new javax.swing.JLabel();
        Thu_8_label = new javax.swing.JLabel();
        Fri_8_label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(970, 600));
        getContentPane().setLayout(null);

        TimeSlot4_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimeSlot4_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeSlot4_label.setText("9.50AM -10.30 AM");
        getContentPane().add(TimeSlot4_label);
        TimeSlot4_label.setBounds(50, 300, 140, 30);

        TimeSlot8_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimeSlot8_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeSlot8_label.setText("12.50PM-1.30PM");
        getContentPane().add(TimeSlot8_label);
        TimeSlot8_label.setBounds(50, 500, 140, 30);

        TimeSlot5_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimeSlot5_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeSlot5_label.setText("10.50AM -11.30 AM");
        getContentPane().add(TimeSlot5_label);
        TimeSlot5_label.setBounds(50, 380, 140, 30);

        TimeSlot6_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimeSlot6_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeSlot6_label.setText("11.30AM -12.10 PM");
        getContentPane().add(TimeSlot6_label);
        TimeSlot6_label.setBounds(50, 420, 140, 30);

        TimeSlot1_Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimeSlot1_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeSlot1_Label.setText("7.50AM -8.30 AM");
        getContentPane().add(TimeSlot1_Label);
        TimeSlot1_Label.setBounds(50, 180, 140, 30);

        TimeSlot2_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimeSlot2_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeSlot2_label.setText("8.30AM -9.10 AM");
        getContentPane().add(TimeSlot2_label);
        TimeSlot2_label.setBounds(50, 220, 140, 30);

        TimeSlot_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimeSlot_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeSlot_label.setText("9.10AM -9.50 AM");
        getContentPane().add(TimeSlot_label);
        TimeSlot_label.setBounds(50, 260, 140, 30);

        TimeSlot7_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimeSlot7_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeSlot7_label.setText("12.10PM-12.50PM");
        getContentPane().add(TimeSlot7_label);
        TimeSlot7_label.setBounds(50, 460, 140, 30);

        Mon_1_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mon_1_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mon_1_label.setText("class");
        getContentPane().add(Mon_1_label);
        Mon_1_label.setBounds(190, 180, 140, 30);

        Mon_2_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mon_2_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mon_2_label.setText("class");
        getContentPane().add(Mon_2_label);
        Mon_2_label.setBounds(190, 220, 140, 30);

        Mon_3_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mon_3_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mon_3_label.setText("class");
        getContentPane().add(Mon_3_label);
        Mon_3_label.setBounds(190, 260, 140, 30);

        Mon_4_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mon_4_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mon_4_label.setText("class");
        getContentPane().add(Mon_4_label);
        Mon_4_label.setBounds(190, 300, 140, 30);

        Mon_5_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mon_5_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mon_5_label.setText("class");
        getContentPane().add(Mon_5_label);
        Mon_5_label.setBounds(190, 380, 140, 30);

        Mon_6_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mon_6_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mon_6_label.setText("class");
        getContentPane().add(Mon_6_label);
        Mon_6_label.setBounds(190, 420, 140, 30);

        Mon_7_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mon_7_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mon_7_label.setText("class");
        getContentPane().add(Mon_7_label);
        Mon_7_label.setBounds(190, 460, 140, 30);

        Mon_8_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mon_8_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mon_8_label.setText("class");
        getContentPane().add(Mon_8_label);
        Mon_8_label.setBounds(190, 500, 140, 30);

        Tue_1_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tue_1_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tue_1_label.setText("class");
        getContentPane().add(Tue_1_label);
        Tue_1_label.setBounds(340, 180, 140, 30);

        Tue_2_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tue_2_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tue_2_label.setText("class");
        getContentPane().add(Tue_2_label);
        Tue_2_label.setBounds(340, 220, 140, 30);

        Tue_3_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tue_3_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tue_3_label.setText("class");
        getContentPane().add(Tue_3_label);
        Tue_3_label.setBounds(340, 260, 140, 30);

        Tue_4_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tue_4_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tue_4_label.setText("class");
        getContentPane().add(Tue_4_label);
        Tue_4_label.setBounds(340, 300, 140, 30);

        Tue_5_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tue_5_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tue_5_label.setText("class");
        getContentPane().add(Tue_5_label);
        Tue_5_label.setBounds(340, 380, 140, 30);

        Tue_6_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tue_6_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tue_6_label.setText("class");
        getContentPane().add(Tue_6_label);
        Tue_6_label.setBounds(340, 420, 140, 30);

        Tue_7_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tue_7_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tue_7_label.setText("class");
        getContentPane().add(Tue_7_label);
        Tue_7_label.setBounds(340, 460, 140, 30);

        Tue_8_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tue_8_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tue_8_label.setText("class");
        getContentPane().add(Tue_8_label);
        Tue_8_label.setBounds(340, 500, 140, 30);

        Wen_3_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Wen_3_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Wen_3_label.setText("class");
        getContentPane().add(Wen_3_label);
        Wen_3_label.setBounds(490, 260, 140, 30);

        Wen_4_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Wen_4_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Wen_4_label.setText("class");
        getContentPane().add(Wen_4_label);
        Wen_4_label.setBounds(490, 300, 140, 30);

        Wen_1_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Wen_1_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Wen_1_label.setText("class");
        getContentPane().add(Wen_1_label);
        Wen_1_label.setBounds(490, 180, 140, 30);

        Wen_7_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Wen_7_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Wen_7_label.setText("class");
        getContentPane().add(Wen_7_label);
        Wen_7_label.setBounds(490, 460, 140, 30);

        Wen_2_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Wen_2_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Wen_2_label.setText("class");
        getContentPane().add(Wen_2_label);
        Wen_2_label.setBounds(490, 220, 140, 30);

        Wen_8_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Wen_8_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Wen_8_label.setText("class");
        getContentPane().add(Wen_8_label);
        Wen_8_label.setBounds(490, 500, 140, 30);

        Wen_6_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Wen_6_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Wen_6_label.setText("class");
        getContentPane().add(Wen_6_label);
        Wen_6_label.setBounds(490, 420, 140, 30);

        Wen_5_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Wen_5_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Wen_5_label.setText("class");
        getContentPane().add(Wen_5_label);
        Wen_5_label.setBounds(490, 380, 140, 30);

        Thu_1_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Thu_1_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Thu_1_label.setText("class");
        getContentPane().add(Thu_1_label);
        Thu_1_label.setBounds(630, 180, 140, 30);

        Fri_1_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fri_1_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fri_1_label.setText("class");
        getContentPane().add(Fri_1_label);
        Fri_1_label.setBounds(780, 180, 140, 30);

        Thu_2_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Thu_2_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Thu_2_label.setText("class");
        getContentPane().add(Thu_2_label);
        Thu_2_label.setBounds(630, 220, 140, 30);

        Fri_2_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fri_2_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fri_2_label.setText("class");
        getContentPane().add(Fri_2_label);
        Fri_2_label.setBounds(780, 220, 140, 30);

        Thu_3_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Thu_3_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Thu_3_label.setText("class");
        getContentPane().add(Thu_3_label);
        Thu_3_label.setBounds(630, 260, 140, 30);

        Fri_3_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fri_3_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fri_3_label.setText("class");
        getContentPane().add(Fri_3_label);
        Fri_3_label.setBounds(780, 260, 140, 30);

        Thu_4_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Thu_4_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Thu_4_label.setText("class");
        getContentPane().add(Thu_4_label);
        Thu_4_label.setBounds(630, 300, 140, 30);

        Fri_4_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fri_4_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fri_4_label.setText("class");
        getContentPane().add(Fri_4_label);
        Fri_4_label.setBounds(780, 300, 140, 30);

        Thu_5_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Thu_5_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Thu_5_label.setText("class");
        getContentPane().add(Thu_5_label);
        Thu_5_label.setBounds(630, 380, 140, 30);

        Fri_5_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fri_5_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fri_5_label.setText("class");
        getContentPane().add(Fri_5_label);
        Fri_5_label.setBounds(780, 380, 140, 30);

        Thu_6_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Thu_6_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Thu_6_label.setText("class");
        getContentPane().add(Thu_6_label);
        Thu_6_label.setBounds(630, 420, 140, 30);

        Fri_6_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fri_6_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fri_6_label.setText("class");
        getContentPane().add(Fri_6_label);
        Fri_6_label.setBounds(780, 420, 140, 30);

        Thu_7_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Thu_7_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Thu_7_label.setText("class");
        getContentPane().add(Thu_7_label);
        Thu_7_label.setBounds(630, 460, 140, 30);

        Fri_7_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fri_7_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fri_7_label.setText("class");
        getContentPane().add(Fri_7_label);
        Fri_7_label.setBounds(780, 460, 140, 30);

        Thu_8_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Thu_8_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Thu_8_label.setText("class");
        getContentPane().add(Thu_8_label);
        Thu_8_label.setBounds(630, 500, 140, 30);

        Fri_8_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fri_8_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fri_8_label.setText("class");
        getContentPane().add(Fri_8_label);
        Fri_8_label.setBounds(780, 500, 140, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/time_table_image.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 950, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fri_1_label;
    private javax.swing.JLabel Fri_2_label;
    private javax.swing.JLabel Fri_3_label;
    private javax.swing.JLabel Fri_4_label;
    private javax.swing.JLabel Fri_5_label;
    private javax.swing.JLabel Fri_6_label;
    private javax.swing.JLabel Fri_7_label;
    private javax.swing.JLabel Fri_8_label;
    private javax.swing.JLabel Mon_1_label;
    private javax.swing.JLabel Mon_2_label;
    private javax.swing.JLabel Mon_3_label;
    private javax.swing.JLabel Mon_4_label;
    private javax.swing.JLabel Mon_5_label;
    private javax.swing.JLabel Mon_6_label;
    private javax.swing.JLabel Mon_7_label;
    private javax.swing.JLabel Mon_8_label;
    private javax.swing.JLabel Thu_1_label;
    private javax.swing.JLabel Thu_2_label;
    private javax.swing.JLabel Thu_3_label;
    private javax.swing.JLabel Thu_4_label;
    private javax.swing.JLabel Thu_5_label;
    private javax.swing.JLabel Thu_6_label;
    private javax.swing.JLabel Thu_7_label;
    private javax.swing.JLabel Thu_8_label;
    private javax.swing.JLabel TimeSlot1_Label;
    private javax.swing.JLabel TimeSlot2_label;
    private javax.swing.JLabel TimeSlot4_label;
    private javax.swing.JLabel TimeSlot5_label;
    private javax.swing.JLabel TimeSlot6_label;
    private javax.swing.JLabel TimeSlot7_label;
    private javax.swing.JLabel TimeSlot8_label;
    private javax.swing.JLabel TimeSlot_label;
    private javax.swing.JLabel Tue_1_label;
    private javax.swing.JLabel Tue_2_label;
    private javax.swing.JLabel Tue_3_label;
    private javax.swing.JLabel Tue_4_label;
    private javax.swing.JLabel Tue_5_label;
    private javax.swing.JLabel Tue_6_label;
    private javax.swing.JLabel Tue_7_label;
    private javax.swing.JLabel Tue_8_label;
    private javax.swing.JLabel Wen_1_label;
    private javax.swing.JLabel Wen_2_label;
    private javax.swing.JLabel Wen_3_label;
    private javax.swing.JLabel Wen_4_label;
    private javax.swing.JLabel Wen_5_label;
    private javax.swing.JLabel Wen_6_label;
    private javax.swing.JLabel Wen_7_label;
    private javax.swing.JLabel Wen_8_label;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
