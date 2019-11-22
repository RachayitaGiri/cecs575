/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package microwave;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Dr Hoffman
 */
public class MyTimer {
    private int time; //as seconds
    private boolean isrunning;
    Timer t;
    
    Oven oven;

    public MyTimer(Oven oven){
        isrunning = false;
        time = 0;
        this.oven = oven;
        
    }

    public void Add1Minute() {
        if (isrunning) return;
        t = new Timer();
        time = 60;
        isrunning = true;
        System.out.println("Added 1 minute of cook time");
        StartTimer();
    }

    public void AddExtraMinute(){
        time = time + 60;
        System.out.println("Added 1 minute of cook time");
    }

    private void StartTimer(){
      t.scheduleAtFixedRate(new TimerTask(){
                public void run(){
                    System.out.println(time);
                    time--;
                    if(time == 0){
                        Alert();
                        t.cancel();
                    }
                }
        }, 0, 1000);  //TimerTask, startAtOnce, Milliseconds
    }

    public void Alert(){
        oven.TimerExpired();
        isrunning = false;
    }

    boolean isRunning(){
        return isrunning;
    }

    public void Cancel(){
        t.cancel();
        time = 0;
        isrunning = false;
    }
}
