package com.vendettasoft.vendetta.controllers.async.traini;


import com.vendettasoft.vendetta.services.traini.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiThreadsController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping(value = "/start-single-multithreads")
    public String startSimpleThreads(@RequestParam(value = "workingTime") Integer workingTime) {

        threadService.startThreadsWithTime(workingTime);

        return "SUCCESS";
    }


}
