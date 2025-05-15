/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DiaryEntryDTO;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class DiaryEntryDAO {

    public List<DiaryEntryDTO> getUserDiaryEntries(String username) {
        List<DiaryEntryDTO> entryList = new ArrayList<>();
        String sql = "SELECT EntryID, username, entry_date, entry_content, status FROM DiaryEntries WHERE username = ? ORDER BY entry_date DESC";

        try {
            Connection conn = DBUtils.getConnection();
                PreparedStatement ptm = conn.prepareStatement(sql);
            ptm.setString(1, username);
            ResultSet rs = ptm.executeQuery();

            while (rs.next()) {
                int entryID = rs.getInt("EntryID");
                String date = rs.getString("entry_date");
                String content = rs.getString("entry_content");
                String status = rs.getString("status");

                entryList.add(new DiaryEntryDTO(entryID, username, date, content, status));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entryList;
    }

    public DiaryEntryDTO getDiaryEntryById(int entryID) {
        String sql = "SELECT EntryID, username, entry_date, entry_content, status FROM DiaryEntries WHERE EntryID = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ptm = conn.prepareStatement(sql);

            ptm.setInt(1, entryID);
            ResultSet rs = ptm.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String date = rs.getString("entry_date");
                String content = rs.getString("entry_content");
                String status = rs.getString("status");

                return new DiaryEntryDTO(entryID, username, date, content, status);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addDiaryEntry(DiaryEntryDTO entry) {
        String sql = "INSERT INTO DiaryEntries (username, entry_date, entry_content, status) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ptm = conn.prepareStatement(sql);
            ptm.setString(1, entry.getUsername());
            ptm.setString(2, entry.getEntryDate());
            ptm.setString(3, entry.getEntryContent());
            ptm.setString(4, entry.getStatus());

            return ptm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDiaryEntry(DiaryEntryDTO entry) {
        String sql = "UPDATE DiaryEntries SET entry_date = ?, entry_content = ?, status = ? WHERE EntryID = ? AND username = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ptm = conn.prepareStatement(sql);
            ptm.setString(1, entry.getEntryDate());
            ptm.setString(2, entry.getEntryContent());
            ptm.setString(3, entry.getStatus());
            ptm.setInt(4, entry.getEntryID());
            ptm.setString(5, entry.getUsername());

            return ptm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDiaryEntry(int entryID, String username) {
        String sql = "DELETE FROM DiaryEntries WHERE EntryID = ? AND username = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ptm = conn.prepareStatement(sql);
            ptm.setInt(1, entryID);
            ptm.setString(2, username);

            return ptm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getMaxEntryID() {
        String sql = "SELECT MAX(EntryID) AS maxID FROM DiaryEntries";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ptm = conn.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                return rs.getInt("maxID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<DiaryEntryDTO> getDoneStatus(String username) {
        List<DiaryEntryDTO> entryList = new ArrayList<>();

        String sql = "SELECT EntryID, username, entry_date, entry_content, status FROM DiaryEntries WHERE status = 'Done' AND username = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ptm = conn.prepareStatement(sql);
            ptm.setString(1, username);

            ResultSet rs = ptm.executeQuery();

            while (rs.next()) {
                int entryID = rs.getInt("EntryID");
                String entryDate = rs.getString("entry_date");
                String entryContent = rs.getString("entry_content");
                String status = rs.getString("status");

                // Create DiaryEntryDTO object and add it to the list
                DiaryEntryDTO entry = new DiaryEntryDTO(entryID, username, entryDate, entryContent, status);
                entryList.add(entry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entryList;
    }
}
