/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AcademicMember;
import Model.ClassRoom;
import Model.Student;
import Model.Subject;
import db.DB_Connection;
import db.DB_Handler;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lahiru Sandeepa
 */
public class AcademicStaffController {
   
   //Lahiru Sandeepa
   public static AcademicMember searchTeacherById(int memberID) throws ClassNotFoundException, SQLException {
         int teacher_id;
        teacher_id = memberID;
        AcademicMember teacher =null;
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="select * from academic_staff_member where member_id='"+teacher_id+"'";
        ResultSet resultSet=DB_Handler.getData(connection,sql);
        if(resultSet.next()){
            teacher=new AcademicMember(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getBinaryStream(7),resultSet.getString(8),resultSet.getString(9),resultSet.getDate(10));
            //teacher.setClassRoom(ClassRoomController.searchClassRoomByID(resultSet.getInt("current_class_id")));
        }
        return teacher;
    }
   //Lahiru Sandeepa
   public static void set_teacherUpdate(AcademicMember teacher) throws SQLException, ClassNotFoundException{
        
       Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="UPDATE academic_staff_member SET telephone = '"+teacher.getTelephoneNo()+
                "', name= '"+teacher.getName()+"'"+"', email= '"+teacher.getEmail()+"'"+"', Rank= '"+teacher.getDesignation()+"'"+
                    "', address= '"+teacher.getAddress()+"'"+"', mobile= '"+teacher.getMobileNo()+"'"+"', photograph= '"+teacher.getImage()+"'"+
                        "', nic= '"+teacher.getNic()+"'"+"WHERE member_id ='"+teacher.getMemberId()+"'";
        int status = DB_Handler.setData(connection, sql);
      
        
   }
   //Hashini Galappaththi
   //get peticular teacher's detail to show to  student
   public static AcademicMember get_teachers_detail(int Student_id) throws SQLException, ClassNotFoundException{
   
   AcademicMember academicMember=null;
   //get class id
   int class_id=StudentController.getStudentClassRoom(Student_id);
   //get teacher's id
   
   int teachers_id=ClassRoomController.get_Classteachers_Id(class_id);
   
   //get teachers detatil
   Connection connection=DB_Connection.getDBConnection().getConnection();
   String sql="SELECT * FROM academic_staff_member WHERE member_id='"+Integer.toString(teachers_id)+"'";
   ResultSet resultSet=DB_Handler.getData(connection, sql);
   if(resultSet.next()){
   
        academicMember = new AcademicMember(resultSet.getInt("member id"),resultSet.getString("name"),resultSet.getString("address"),resultSet.getInt("telephone"),resultSet.getInt("mobile")
               ,resultSet.getString("Rank"), (InputStream) resultSet.getBlob("Photograph"),resultSet.getString("email"),resultSet.getString("nic"),resultSet.getDate("birthday"));
             academicMember.setSubjects(SubjectController.getSubjectForTeacher(resultSet.getInt("member_id")));
   }
   
   
   return academicMember;
   
   }
   //hahini Galappaththi called from student_teacher_view method:set table
   public static ArrayList<AcademicMember> getListOfTeachers(String name) throws ClassNotFoundException, SQLException{
   AcademicMember academicMember=null;
   
   ArrayList<AcademicMember> teachers=new ArrayList<>();
   Connection connection=DB_Connection.getDBConnection().getConnection();
   String sql="SELECT * FROM academic_staff_member WHERE name='"+name+"'";
   ResultSet resultSet=DB_Handler.getData(connection, sql);
   while(resultSet.next()){
  academicMember = new AcademicMember(resultSet.getInt("member_id"),resultSet.getString("name"),resultSet.getString("address"),resultSet.getInt("telephone"),resultSet.getInt("mobile")
               ,resultSet.getString("Rank"), (InputStream) resultSet.getBlob("Photograph"),resultSet.getString("email"),resultSet.getString("nic"),resultSet.getDate("birthday"));
   academicMember.setSubjects(SubjectController.getSubjectForTeacher(resultSet.getInt("member_id")));   
  teachers.add(academicMember);
   }
   
   return teachers;
   
   
   }
   //Hashini Galappaththi cllled from student_teacher_view method:set table BY grade radio button selected
   public static ArrayList<AcademicMember> returnListOfTeachers(String grade) throws ClassNotFoundException, SQLException{
   
   ArrayList<AcademicMember> teachers=new ArrayList<>();
   ArrayList<Integer> teacher_id=TimeTableController.returnTeacherId(grade);
   AcademicMember academicMember;
   if(!teacher_id.isEmpty()){
   Connection connection=DB_Connection.getDBConnection().getConnection();
   for(int i=0;i<teacher_id.size();i++){
   String sql="SELECT * FROM academic_staff_member WHERE member_id'"+Integer.toString(teacher_id.get(i))+"'";
   ResultSet resultSet=DB_Handler.getData(connection, sql);
   
   while(resultSet.next()){
  academicMember = new AcademicMember(resultSet.getInt("member_id"),resultSet.getString("name"),resultSet.getString("address"),resultSet.getInt("telephone"),resultSet.getInt("mobile")
               ,resultSet.getString("Rank"), (InputStream) resultSet.getBlob("Photograph"),resultSet.getString("email"),resultSet.getString("nic"),resultSet.getDate("birthday"));
     
   academicMember.setSubjects(SubjectController.getSubjectForTeacher(resultSet.getInt("member_id")));
  
  teachers.add(academicMember);
   }
           }
   }
   
   
   
   return teachers;
   
   }
   //Hashini Galappaththi cllled from student_teacher_view method:set table BY subject radio button selected
   public static ArrayList<AcademicMember> returnListOfTeachers2(String subject) throws ClassNotFoundException, SQLException{
   
   ArrayList<AcademicMember> teachers=new ArrayList<>();
    ArrayList<Integer> teacher_id=TeacherSubjectController.getTeachers(subject);
    AcademicMember academicMember;
   
     if(!teacher_id.isEmpty()){
   Connection connection=DB_Connection.getDBConnection().getConnection();
   for(int i=0;i<teacher_id.size();i++){
   String sql="SELECT * FROM academic_staff_member WHERE member_id'"+Integer.toString(teacher_id.get(i))+"'";
   ResultSet resultSet=DB_Handler.getData(connection, sql);
   
   while(resultSet.next()){
  academicMember = new AcademicMember(resultSet.getInt("member_id"),resultSet.getString("name"),resultSet.getString("address"),resultSet.getInt("telephone"),resultSet.getInt("mobile")
               ,resultSet.getString("Rank"), (InputStream) resultSet.getBlob("Photograph"),resultSet.getString("email"),resultSet.getString("nic"),resultSet.getDate("birthday"));
  
  
  
 academicMember.setSubjects(SubjectController.getSubjectForTeacher(resultSet.getInt("member_id")));
  
  teachers.add(academicMember);
   }
           }
   }
   
   
   return teachers;
   }
  
  


}
