package com.tight.couplng;

public class TightCoupling {
    public static void main(String[] args) {
        UserManager userManager=new UserManager();
        System.out.println(userManager.GetUserInfo());
    }
}
