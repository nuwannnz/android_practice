package com.example.practice1;

public class User {

    private int userID;
    private String userName;
    private String userType;
    private String pwd;

    public User(int userID, String userName, String userType, String pwd) {
        this.userID = userID;
        this.userName = userName;
        this.userType = userType;
        this.pwd = pwd;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
