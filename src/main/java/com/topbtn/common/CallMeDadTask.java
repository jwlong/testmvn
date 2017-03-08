package com.topbtn.common;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by longjinwen on 2017/3/8.
 */
public class CallMeDadTask extends TimerTask {

    public void run() {
        System.out.println("对，快叫爸爸！"+new Date());
    }
}
