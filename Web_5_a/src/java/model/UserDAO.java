/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author admin
 */
public class UserDAO {
    public ArrayList<UserDAO> list = new ArrayList<>();
    
    public UserDTO searchUserById(String username){
        try {
            Connection con = DBUtils.getConnection();
            String sql = "SELECT * FROM tblUsers WHERE userID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            UserDTO user = null;
            while (rs.next()) {                
                String userID = rs.getString("userID");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String roleID = rs.getString("roleID");
                String status = rs.getString("status");
                user = new UserDTO(userID, fullName, password, roleID, status);
            }
            return user;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public UserDTO login(String username, String password){
        UserDTO user = searchUserById(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
