package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User; // Import đúng class User trong package models

public class UsersDAO extends DBContext {

    // 1. Hàm kiểm tra đăng nhập (Trả về User nếu đúng, null nếu sai)
    public User login(String user, String pass) {
        String sql = "SELECT * FROM Users WHERE [user] = ? AND pass = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("uID"),
                        rs.getString("user"),
                        rs.getString("pass"),
                        rs.getInt("isSell"),
                        rs.getInt("isAdmin"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // 2. Hàm kiểm tra tài khoản đã tồn tại chưa (Dùng khi Đăng ký)
    public User checkAccountExist(String user) {
        String sql = "SELECT * FROM Users WHERE [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("uID"),
                        rs.getString("user"),
                        rs.getString("pass"),
                        rs.getInt("isSell"),
                        rs.getInt("isAdmin"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // 3. Hàm Đăng ký tài khoản mới (Insert vào DB)
    public void signup(String user, String pass, String email) {
        // Mặc định isSell = 0, isAdmin = 0
        String sql = "INSERT INTO Users([user], pass, isSell, isAdmin, email) VALUES(?,?,0,0,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.setString(3, email);
            st.executeUpdate(); // Dùng executeUpdate cho lệnh INSERT
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}