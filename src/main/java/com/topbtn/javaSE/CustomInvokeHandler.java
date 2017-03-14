package com.topbtn.javaSE;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by longjinwen on 2017/3/14.
 */
public class CustomInvokeHandler implements InvocationHandler {
    private Object target;
    public CustomInvokeHandler(Object target){
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke ===============>");
        Object retObj = method.invoke(target,args);
        System.out.println("after invoke <===============");
        return retObj;
    }
}
