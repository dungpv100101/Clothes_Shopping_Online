/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Dung
 */
public class Categories {
    private int CategoryID;
    private String CategoryName;
    private String Description;
    private String Picture;

    public Categories() {
    }

    public Categories(int CategoryID, String CategoryName, String Description, String Picture) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.Description = Description;
        this.Picture = Picture;
    }

    public Categories(String CategoryName, String Description, String Picture) {
        this.CategoryName = CategoryName;
        this.Description = Description;
        this.Picture = Picture;
    }
    

    public int getCategoryID() {
        return CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public String getPicture() {
        return Picture;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }
    
    
}
