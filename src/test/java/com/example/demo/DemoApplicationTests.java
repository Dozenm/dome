package com.example.demo;

import com.example.demo.bean.Person;
import com.util.FTPuitl;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;
    @Test
    public void per(){
        System.out.println(person);
    }
    @Test
    public void helloService(){
        System.out.println(ioc.containsBean("helloService"));
    }
    @Test
    public void contextLoads() throws IOException {
//        System.out.println(person);
        FTPuitl ftPuitl=new FTPuitl();
        FTPClient ftpClient=ftPuitl.getConnectionFTP();
        ftPuitl.uploadFile(ftpClient,new FileInputStream(new File("E:/8XU}9[1PEZJJQC)N$4CU@C4.png")));

    }

}
