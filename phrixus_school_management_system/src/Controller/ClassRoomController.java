/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClassRoom;
import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author hp pc
 */
public class ClassRoomController {

    public static ClassRoom searchClassRoomByID(int classId) throws ClassNotFoundException, SQLException {
        ClassRoom classRoom=null;
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM classroom WHERE class_id='"+classId+"'";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
        if(resultSet.next()){
            classRoom=new ClassRoom(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));            
        }
        return classRoom;
    }
    //Lahiru Sandeepa
    public static ClassRoom searchClassRoomby_TeacherID(int teacherId) throws ClassNotFoundException, SQLException {
        ClassRoom classRoom=null;
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM classroom WHERE class_id='"+teacherId+"'";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
        if(resultSet.next()){
            classRoom=new ClassRoom(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));            
        }
        return classRoom;
    }

    public static ClassRoom searchBy_Currant_ClassID(int currant_Class_id)throws ClassNotFoundException, SQLException  {
        ClassRoom classRoom=null;
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM classroom WHERE class_id='"+currant_Class_id+"'";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
        if(resultSet.next()){
            classRoom=new ClassRoom(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));            
        }
        return classRoom;
    }
      //Hahsini Galappaththi to get class teacher's id of peticular class
    public static int get_Classteachers_Id(int class_id) throws ClassNotFoundException, SQLException{
    
    int teachers_id=-999;
    
          Connection connection=DB_Connection.getDBConnection().getConnection();
          String sql="SELECT class_teacher_id FROM classroom WHERE class_id="+class_id+"';";
          ResultSet resultSet=DB_Handler.getData(connection, sql);
          if(resultSet.next()){
          teachers_id=resultSet.getInt("class_teacher_id");
          }
    
    return teachers_id;
    }
    //Hashini Galappaththi to get class room ids using grade
    public static ArrayList<Integer> getClassRoomId (String grade) throws ClassNotFoundException, SQLException{
    
    ArrayList<Integer> class_id=new ArrayList<>();
    Connection connection=DB_Connection.getDBConnection().getConnection();
    String sql="SELECT * FROM classroom WHERE grade_id='"+grade+"'";
    ResultSet resultSet=DB_Handler.getData(connection, sql);
    while(resultSet.next()){
    int getClassId=resultSet.getInt("class_id");
    class_id.add(getClassId);
    
    }
    
    
    
    return class_id;
    }
    
    
    //@Yasiru
    public static ClassRoom get_Class_Id(int Grade,String Class) throws ClassNotFoundException, SQLException{
    ClassRoom classRoom=null; 
    
          Connection connection=DB_Connection.getDBConnection().getConnection();
          String sql="SELECT class_id FROM classroom WHERE Grade='"+Grade+"'and Class='"+Class+"' ;"; // classid='232' 
          ResultSet resultSet=DB_Handler.getData(connection, sql);
          if(resultSet.next()){
              int class_id=resultSet.getInt("class_id");
              
              classRoom=new ClassRoom(class_id, Class, Grade);
              
          }
    return classRoom;
    }
    
    
    
    
    
    
    
    
}
