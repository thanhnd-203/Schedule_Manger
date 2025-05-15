/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class TestDBConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công!");
                conn.close();
            } else {
                System.out.println("Kết nối thất bại!");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
