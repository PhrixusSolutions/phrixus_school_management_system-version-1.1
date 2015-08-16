/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Achievement;
import Model.Student;
import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp pc
 */
public class StudentController {
    //@Yasiru
    public static Student searchStudentById(String studentID) throws ClassNotFoundException, SQLException {
        Student student=null;
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="select * from student where student_id='"+studentID+"'";
        ResultSet resultSet=DB_Handler.getData(connection,sql);
        if(resultSet.next()){
            student=new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDate(6), resultSet.getBinaryStream(7),resultSet.getString(8));
            student.setClassRoom(ClassRoomController.searchClassRoomByID(resultSet.getInt("current_class_id")));
        }
        return student;
    }

    
    
    
    public static ArrayList<Student> getFullStudentList() throws SQLException, ClassNotFoundException {
        ArrayList<Student> studentList=new ArrayList<>();
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM student";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
        while(resultSet.next()){
            //Student student=new Student(resultSet.getString("residence_address"), resultSet.getString("full_name"), resultSet.getInt("currant_class_id"), resultSet.getInt("telephone"), resultSet.getString("permanent_address"), resultSet.getDate("birthday"), resultSet.getBinaryStream("photograph"),resultSet.getInt("student_id"));
            /*
                As in the above code, you can get the result list by getting value of each column.
                If you give column number to get methods, you should be very careful with the order of the mysql columns and the order of Model class constructor parameters.
                resultset.nect method moves to the next row of data.
                if there are no more rows, it returns false
            */
            //student.setClassRoom(ClassRoomController.searchClassRoomByID(resultSet.getInt("current_class_id"))); 
            /*
                instead of giving the column number, you can give the column name to the get methodes as above. 
                the column name should be exactly same to those in the table.
            */
            
            //student.setGuardianList(GuardianRelationshipController.getGuardians(resultSet.getInt(1)));
            
            //studentList.add(student);
        }
        return studentList;
    }
    //Lahiru Sandeepa
    public static ArrayList<Student> getStudentList_InClass(int class_id) throws SQLException, ClassNotFoundException {
        
        ArrayList<Student> studentList=new ArrayList<>();
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM student where currant_class_id='"+class_id+"'";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
       
        while(resultSet.next()){
            //Student student=new Student(resultSet.getString("residence_address"), resultSet.getString("full_name"), resultSet.getInt("currant_class_id"), resultSet.getInt("telephone"), resultSet.getString("permanent_address"), resultSet.getDate("birthday"), resultSet.getBinaryStream("photograph"),resultSet.getInt("student_id"));
            //student.setClassRoom(ClassRoomController.searchClassRoomByID(resultSet.getInt("current_class_id"))); 
            //student.setGuardianList(GuardianRelationshipController.getGuardians(resultSet.getInt(1)));
            //studentList.add(student);
        }
        return studentList;
    }
    //Lahiru Sandeepa for Achivements
    public static ArrayList<Student> getStudentImageList(ArrayList<Achievement> AchievementList)throws ClassNotFoundException, SQLException {
         ArrayList<Student> studentList=new ArrayList<>();
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM student";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
        while(resultSet.next()){
            //Student student=new Student(resultSet.getString("residence_address"), resultSet.getString("full_name"), resultSet.getInt("currant_class_id"), resultSet.getInt("telephone"), resultSet.getString("permanent_address"), resultSet.getDate("birthday"), resultSet.getBinaryStream("photograph"),resultSet.getInt("student_id"));
            int countAchiventList_Index = 0;
            while(AchievementList.isEmpty()){
                int student_id = AchievementList.get(countAchiventList_Index).getAchieverId();
//                if(student.getStudentId() == student_id){
//                    studentList.add(student);
//                }
                countAchiventList_Index++;
            }
        }
        
        return studentList;
    }
    /* Lahiru Sandeepa
    this methord for get search result by search keyword by student name, teacher_student_class
    */
    public static ArrayList<Student> searchStudentByName(String searchWord) throws ClassNotFoundException, SQLException {
        ArrayList<Student> studentList=new ArrayList<>();
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM student";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
        while(resultSet.next()){
            //Student student=new Student(resultSet.getString("residence_address"), resultSet.getString("full_name"), resultSet.getInt("currant_class_id"), resultSet.getInt("telephone"), resultSet.getString("permanent_address"), resultSet.getDate("birthday"), resultSet.getBinaryStream("photograph"),resultSet.getInt("student_id"));
//            if(student.getFullName().contentEquals(searchWord)){
//                
//                studentList.add(student);
//            }
        }
        return studentList;
}
    //Hashini Galappaththi to get student's class room id
    public static int getStudentClassRoom(int student_id) throws SQLException, ClassNotFoundException{
    
    int classId=-999;
    Connection connection=DB_Connection.getDBConnection().getConnection();
    String sql="SELECT current_class_id FROM student WHERE student_id='"+Integer.toString(student_id)+"';";
    ResultSet resultSet=DB_Handler.getData(connection, sql);
    if(resultSet.next()){
    classId=resultSet.getInt("current_class_id");
    }
    
    
    return classId;
    
    }
    //@Yasiru
    public static void SaveStudent(Student student) throws ClassNotFoundException, SQLException {
        
        Connection connection=DB_Connection.getDBConnection().getConnection();
        //String sql="INSERT INTO phrixus_db.student (student_id, full_name, permanent_address, residence_address, telephone, birthday, current_class_id, house) VALUES ('2', 'nimal', 'Yehiya road,Matara', 'Katubedda,Moratuwa', '9373728929', '1992-10-22', '3', 'Olu')";
        String sql="INSERT INTO phrixus_db.student (student_id, full_name, permanent_address, residence_address, telephone, birthday, current_class_id, house) VALUES (Student.getStudentId(), Student.getFullName(), Student.getPermenantAddress(), Student.getResidenceAddress(), Student.getTelephoneNo(), Student.getBirthday(), Student.getClassRoom(), Student.getHouse())";
        
        
        
        
    }

}
