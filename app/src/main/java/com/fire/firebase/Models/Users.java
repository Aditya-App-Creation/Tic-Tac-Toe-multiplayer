package com.fire.firebase.Models;

public class Users {

    public Users(String profilepic, String username, String userId, String password, String lastmessage) {
        this.profilepic = profilepic;
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.lastmessage = lastmessage;
    }



    String profilepic;
    String username;
    public Users() {}

    //sign up
    public  Users(String username, String email, String password) {
        this.username = username;
        this.userId = email;
        this.password = password;

    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastmessage() {
        return lastmessage;
    }

    public void setLastmessage(String lastmessage) {
        this.lastmessage = lastmessage;
    }

    String userId;
    String password;
    String lastmessage;
}
