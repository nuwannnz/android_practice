package com.example.practice1;

public class Message {
    private int msgID;
    private String userName;
    private String subject;
    private String msg;

    public Message(int msgID, String userName, String subject, String msg) {
        this.msgID = msgID;
        this.userName = userName;
        this.subject = subject;
        this.msg = msg;
    }

    public int getMsgID() {
        return msgID;
    }

    public void setMsgID(int msgID) {
        this.msgID = msgID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
