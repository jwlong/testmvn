package com.topbtn.test;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by longjinwen on 2017/3/8.
 */
public class Test1 extends TestCase {
    public static void main(String[] args) {
        System.out.println("aaaa");
    }

    @Test
    public void test1(){
        Properties properties = new Properties();
        InputStream in = null;
        try {
            //in = new FileInputStream("resource.properties");
            in = Test1.class.getResourceAsStream("/resource.");
            properties.load(in);
         //   Assert.assertThat();
            System.out.println(properties.getProperty("lable.text.test"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
