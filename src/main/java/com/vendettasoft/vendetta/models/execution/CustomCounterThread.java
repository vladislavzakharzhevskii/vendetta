package com.vendettasoft.vendetta.models.execution;

public class CustomCounterThread implements Runnable {


    private volatile boolean upDirectional;
    private volatile boolean stopExecution;
    private int counter = 0;


    public void changeDirectional() {
        this.upDirectional = !this.upDirectional;
    }

    @Override
    public void run() {

        do {

//            //WAITING FOR A SECOND
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//            }

            //STOP THREAD AND RETURN OUT
            if (stopExecution) {
                return;
            }



            if (!upDirectional)
            {
                counter = counter - 1;
                System.out.println("Value is: " + counter);
            }
            else
            {
                counter = counter + 1;
                System.out.println("Value is: " + counter);
            }



        } while (true);


    }

    public void stopExecution() {
        this.stopExecution = true;
    }
}
