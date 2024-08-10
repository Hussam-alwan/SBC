package com.loose.coupling;

public class UserDataBaseProvider implements UserDateProvider {

    @Override
    public String getUserDetails(){
        return "User Details From Database";
    }
}
