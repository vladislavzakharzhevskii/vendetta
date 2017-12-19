package com.vendettasoft.vendetta.services.traini;

import com.vendettasoft.vendetta.models.traini.execution.CustomCounterThread;
import org.springframework.stereotype.Service;

@Service
public class ThreadServiceImpl implements ThreadService {


    @Override
    public void startThreadsWithTime(int workingTime) {

        CustomCounterThread thread = new CustomCounterThread();
        Thread wrappedThread = new Thread(thread, "CustomCounterThread");
        wrappedThread.start();


        for (int i = 0; i < workingTime; i ++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){}

            //CHANGE DIRECTION
            thread.changeDirectional();

        }


        thread.stopExecution();
        System.out.println("MAIN THREAD HAS STOPPED!");


    }
}
