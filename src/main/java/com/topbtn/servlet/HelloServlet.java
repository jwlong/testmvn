package com.topbtn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by longjinwen on 2017/3/9.
 */
public class HelloServlet  extends HttpServlet{
    String message;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("service () invoke............");
//        message = req.getParameter("message");
//        PrintWriter pw = resp.getWriter();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        pw.write("<div><strong>Hello World</strong></div>");
//        pw.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // message = req.getParameter("message");

//        PrintWriter pw = resp.getWriter();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        这个时候就有线程安全的问题了 ,真心不错。
//        pw.write("<div><strong>Hello World</strong></div>"+message);
//        pw.close();

        //加同步锁 这个对象锁住就能解决同步问题了，
        //最后注明，在servlet里不到万不得已的时候不要使用成员变量
        synchronized (this){
            message = req.getParameter("message");
            PrintWriter pw = resp.getWriter();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        这个时候就解决线程安全的问题了 ,真心不错。
            pw.write("<div><strong>Hello World</strong></div>"+message);
            pw.close();
        }
    }
}
