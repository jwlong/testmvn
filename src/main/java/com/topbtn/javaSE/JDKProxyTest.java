package com.topbtn.javaSE;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.*;

/**
 * Created by longjinwen on 2017/3/14.
 */
public class JDKProxyTest extends TestCase{
    @Test
    public void test1(){
        //流程，先是有JDKProxy
        CustomInvokeHandler customInvokeHandler = new CustomInvokeHandler(new HelloWorldImpl());
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader()
                ,new Class[]{HelloWorld.class},customInvokeHandler);
        proxy.sayHello("longjinwen");
    }

    /**
     * 测试Set 添加相同的元素的情况
     */
    @Test
    public void test2(){
        Set<Integer>  setSeqs = new  HashSet<Integer>();
        setSeqs.add(1);
        setSeqs.add(1);
        int size=setSeqs.size();
        System.out.println(size);

    }
    public void test3(){
        Set<List<String>> set = new HashSet<List<String>>();
//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        set.add(list);

        for (int i=0;i <2;i++){
            List<String> list = new ArrayList<String>();
            list.add("1");
            list.add("2");
            System.out.println(set.add(list));
        }

    }
}
