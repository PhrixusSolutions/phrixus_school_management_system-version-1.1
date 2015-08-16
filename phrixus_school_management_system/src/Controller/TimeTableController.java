/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import Model.TimeTable;
import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lahiru Sandeepa
 */
public class TimeTableController {
    //Lahiru Sandeepa
    public static ArrayList<TimeTable> getTimeTable_of_Teacher(int teacher_id) throws SQLException, ClassNotFoundException {
        
        ArrayList<TimeTable> Timetable=new ArrayList<>();
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM timetable where currant_class_id='"+teacher_id+"'";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
       
        while(resultSet.next()){
            TimeTable timeslots=new TimeTable(resultSet.getInt("class_id"), resultSet.getInt("subject_id"), resultSet.getInt("teacher_id"), resultSet.getInt("period_id"), resultSet.getDate("year"));
            Date year = new Date();
            if(timeslots.getYear().getYear() == year.getYear() ){ 
            // cheak the year is currant year, then it should be this year time slot
                    Timetable.add(timeslots);
            }   
        }
        return Timetable;
    }
    //Hashini Galappaththi return teachers id for perticular grade 
    public static ArrayList<Integer> returnTeacherId(String grade) throws ClassNotFoundException, SQLException{
    ArrayList<Integer> teacher_Id=new ArrayList<>();
    ArrayList<Integer>class_id=ClassRoomController.getClassRoomId(grade);
    Connection connection=DB_Connection.getDBConnection().getConnection();
    if(!class_id.isEmpty()){
        for(int i=0;i<class_id.size();i++){
    String sql="SELECT * FROM timetable WHERE class_id='"+Integer.toString(class_id.get(i))+"'";
    ResultSet resultSet=DB_Handler.getData(connection, sql);
    while(resultSet.next()){
   int getTeacherId=resultSet.getInt("teacher_id");
   teacher_Id.add(getTeacherId);
    
    }
        }
    }
    
    return teacher_Id;
    
    }
    
}
