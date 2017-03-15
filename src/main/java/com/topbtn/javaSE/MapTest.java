package com.topbtn.javaSE;

/**
 * 测试一下添加相同的元素的情况
 */

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by longjinwen on 2017/3/15.
 */
public class MapTest extends TestCase{
    @Test
    public void test1(){
        Map map = new HashMap();
        MyType type1 = new MyType("john",12);
        MyType type2 = new MyType("john",12);
        map.put(type1,"1");
        map.put(type2,"1");
        System.out.println(map.size()); // print  2
        //这个是因为type1, type2存放在了两个不同的位置上，type1和typ2 只是引用,
        //
        System.out.println(type1.equals(type2)); // print false;
    //        map.put(1,"1");
//        map.put(1,"1");
//        System.out.println(map.size()); // print  1
    }
    @Test
    public void test2(){
        //Mytype2重写了equals和hashCode方法
        Map map = new HashMap();
        MyType2 p1 = new MyType2("jin",28);
        MyType2 p2 = new MyType2("jin",28);
        System.out.println(p1.equals(p2)); // p1,p2 比较数值是不是相等 print true
        System.out.println(p1 == p2); // 比较地址是不是相等 print false

        map.put(p1,11);
        map.put(p2,11);
        System.out.println(map.size()); //print ? 1


    }
}

class MyType{
    private  String name;
    private  int age;


    public MyType(String name, int age) {
        this.name = name;

        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

class MyType2{
    private  String name;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyType2 myType2 = (MyType2) o;

        if (age != myType2.age) return false;
        return name != null ? name.equals(myType2.name) : myType2.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyType2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private  int age;



}

