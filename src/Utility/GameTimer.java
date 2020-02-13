package Utility;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


public class GameTimer implements Runnable {
    private Thread thread;
    private double  sleepTime;
    private volatile boolean finished;

    public void run() {
        finished = false;
        Thread t = new Thread(() -> {
            try {

              //  TimeUnit.SECONDS.sleep(sleepTime);
                Thread.sleep((long)sleepTime);
                this.setFinished(true);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }

    public void startAttackTimer() {
        thread.start();

    }

    public void setFinished(boolean finished){
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }

    public GameTimer(double sleepTime) {
        this.finished = true;
        this.sleepTime = sleepTime;
        thread = new Thread();
    }

}
