package com.topbtn.javaSE;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by longjinwen on 2017/3/14.
 */
public class JDKProxyTest extends TestCase{
    @Test
    public void test1(){
        CustomInvokeHandler customInvokeHandler = new CustomInvokeHandler(new HelloWorldImpl());
        //customInvokeHandler.invoke()
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader()
                ,new Class[]{HelloWorld.class},customInvokeHandler);
        proxy.sayHello("longjinwen");
    }
}
