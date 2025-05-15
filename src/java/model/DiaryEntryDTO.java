/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class DiaryEntryDTO {
     private int entryID;
    private String username;
    private String entryDate;
    private String entryContent;
    private String status;

    public DiaryEntryDTO() {
    }

    public DiaryEntryDTO(int entryID, String username, String entryDate, String entryContent, String status) {
        this.entryID = entryID;
        this.username = username;
        this.entryDate = entryDate;
        this.entryContent = entryContent;
        this.status = status;
    }

    public int getEntryID() {
        return entryID;
    }

    public void setEntryID(int entryID) {
        this.entryID = entryID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEntryContent() {
        return entryContent;
    }

    public void setEntryContent(String entryContent) {
        this.entryContent = entryContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DiaryEntryDTO{" + "entryID=" + entryID + ", username=" + username + ", entryDate=" + entryDate + ", entryContent=" + entryContent + ", status=" + status + '}';
    }

 
    
}
