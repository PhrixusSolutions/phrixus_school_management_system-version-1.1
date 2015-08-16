/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HashiniAG
 */
public class TeacherSubjectController {
    
    
    //Hashini Galappaththi
    //get subjects of peticular teacher   
    public static ArrayList<Integer> getSubjects(int teacher_id) throws ClassNotFoundException, SQLException{
        //return list of subject ids
        ArrayList<Integer> subjects=new ArrayList<>();
        
       Connection connection=DB_Connection.getDBConnection().getConnection();
       String sql="SELECT * FROM teacher_subject WHERE teacher_id='"+Integer.toString(teacher_id)+"'";
       ResultSet resultSet=DB_Handler.getData(connection, sql);
       while(resultSet.next()){
       
       int getSubject=resultSet.getInt("subject_id");
       subjects.add(getSubject);
       
       }
       
        
        return subjects;
    }
    
    public static ArrayList<Integer> getTeachers(String subjectName) throws ClassNotFoundException, SQLException{
        //return list of teacher ids
        int subject_id=SubjectController.returnSubjectId(subjectName);
        ArrayList<Integer> teachers=new ArrayList<>();
        
       Connection connection=DB_Connection.getDBConnection().getConnection();
       if(subject_id!=-999){
       String sql="SELECT * FROM teacher_subject WHERE subject_id='"+Integer.toString(subject_id)+"'";
       ResultSet resultSet=DB_Handler.getData(connection, sql);
       while(resultSet.next()){
       
       int getTeacher=resultSet.getInt("teacher_id");
       teachers.add(getTeacher);
       
       }
       }
        
        return teachers;
    }
    
}
