package com.tight.couplng;

public class UserManager {
    private final UserDataBase userDataBase=new UserDataBase();
    public String GetUserInfo(){
        return userDataBase.getUserDetails();
    }
}
