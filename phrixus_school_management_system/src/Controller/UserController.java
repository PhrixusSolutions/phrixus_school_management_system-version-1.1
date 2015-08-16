/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp pc
 */
public class UserController {
    public static boolean isUserAvailable(User user) throws ClassNotFoundException, SQLException{
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="select * from user where username='"+user.getUsername()+"' and type='"+user.getType()+"' and password='"+user.getPassword()+"'";//FROM `phrixus_db`.`user` WHERE `username`='123' and`password`='asd' and`type`='administrator';
        ResultSet resultSet=DB_Handler.getData(connection,sql);
        if(resultSet.next()){
            return true;
        }
        return false;
    }
}
