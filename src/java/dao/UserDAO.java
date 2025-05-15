/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserDTO;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public UserDTO checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
       
       
      
    String sql = "SELECT username, name, password FROM users WHERE username = ? AND password = ?";
        try {
           Connection conn = DBUtils.getConnection();
           
            PreparedStatement ptm = conn.prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setString(2, password);
             ResultSet rs = ptm.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
              UserDTO user = new UserDTO(username, password, name);
              return user;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public boolean registerUser(String username, String password, String name) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO users (username, password, name) VALUES (?, ?, ?)";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setString(2, password);
            ptm.setString(3, name);

            int rowsAffected = ptm.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }

    public boolean checkExistingUser(String username) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT username FROM users WHERE username = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, username);
            rs = ptm.executeQuery();

            if (rs.next()) {
                result = true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        return result;
    }
}
