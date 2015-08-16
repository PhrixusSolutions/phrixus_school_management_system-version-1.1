/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Marks;
import Model.Student;
import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lahiru Sandeepa
 */
public class EnrollmentController {

    // Lahiru sandeepa
    public static ArrayList<Marks> getEnrollStudentList(ArrayList<Student> studentList, int subject_id) throws ClassNotFoundException, SQLException {
        ArrayList<Marks> enrollstudentList = new ArrayList<>();
        Connection connection=DB_Connection.getDBConnection().getConnection();
        int studentCounter = 0;
        while(studentList.isEmpty()){
            String sql="select * from enrollment where student_id='"+studentList.get(studentCounter).getStudentId()+"' , subject_id ='"+subject_id+"'";
            ResultSet resultSet=DB_Handler.getData(connection,sql);
             if(resultSet.next()){
                 Marks newStudentMarks = new Marks(resultSet.getInt("student_id"), resultSet.getInt("enrollment_id"), resultSet.getInt("subject_id"),resultSet.getDate("year"),studentList.get(studentCounter).getFullName());
                 enrollstudentList.add(newStudentMarks);
             }
        }
        return enrollstudentList;
    
    }

   

   
    
}
