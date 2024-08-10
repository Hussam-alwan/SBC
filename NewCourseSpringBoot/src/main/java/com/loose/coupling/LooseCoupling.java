package com.loose.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LooseCoupling {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationIocLooseCoupling.xml");

        UserManager userManagerWithDB=
                (UserManager) context.getBean("userManagerWithBataBase");
        System.out.println(userManagerWithDB.toString());

        UserManager userManagerWithWS=
                (UserManager) context.getBean("userManagerWithWebService");
        System.out.println(userManagerWithWS.getUserInfo());

    }
}
