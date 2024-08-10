package com.loose.coupling;

public class UserManager {
    private UserDateProvider userDateProvider=new UserDataBaseProvider();

    public UserManager(UserDateProvider userDateProvider) {
        this.userDateProvider = userDateProvider;
    }

    public String getUserInfo(){
        return userDateProvider.getUserDetails();
    }
}
