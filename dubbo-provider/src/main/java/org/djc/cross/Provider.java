package org.djc.cross;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext-dubboprovider.xml");
        context.start();
        System.out.println("end");
        System.in.read();
    }
}
