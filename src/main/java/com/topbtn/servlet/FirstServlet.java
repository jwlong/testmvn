package com.topbtn.servlet;


import com.topbtn.common.CallMeDadTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Timer;
//servlet 是单例
/**
 * Created by longjinwen on 2017/3/8.
 */
public class FirstServlet extends HttpServlet {
   // private Timer timer = new Timer();

//    public Timer getTimer() {
//        return timer;
//    }
//
//    public void setTimer(Timer timer) {
//        this.timer = timer;
//    }

    @Override
    public void init() throws ServletException {
        System.out.println("FirstServlet init() =================>");
        //写个非常简单的定时任务
        Timer timer = new Timer();
        timer.schedule(new CallMeDadTask(),2000,1000);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get 请求过来的");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //super.doPost(req, resp);
       // doGet(req,resp);
        System.out.println("do post from a button firstServlet");
        System.out.println(req.getRemoteHost()+"sdfsd");
        req.getRequestDispatcher("b.jsp").forward(req,resp);
        //return;
    }

    @Override
    public void destroy() {
        System.out.println("FirstServlet destroy() =============> 方法");
        //getTimer().cancel(); //取消定时任务
        System.out.println("OK，不用叫了!");
        super.destroy();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FirstServlet service()");// service方法
        super.service(req, resp);
    }
}
