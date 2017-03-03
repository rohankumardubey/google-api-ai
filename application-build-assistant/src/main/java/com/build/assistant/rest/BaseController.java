package com.build.assistant.rest;

import com.build.assistant.domain.Data;
import com.build.assistant.domain.Request;
import com.build.assistant.domain.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BaseController {

    /* Deploy the application */
    @RequestMapping(value = "/deploy", method = RequestMethod.POST)
    @ResponseBody
    public Response deployApplication(@RequestBody Request request){
        Response response = new Response();
        if(request != null && request.getResult() != null && request.getResult().getAction().equals("application.deploy")){

            response.setSpeech(" Successfully deployed ");
            response.setDisplayText("Display Successfully Deployed");
            Data data = new Data();
            data.setAdditionalProperty("Depployed", request.getResult().getAction().toString());
            response.setData(data);
            List<Object> context = new ArrayList<>();
            context.add("deploycontext");
            response.setContextOut(context);
        }else if(request != null && request.getResult() != null && request.getResult().getAction().equals("getBranches")){
            response.setSpeech(" List of Branches is Dev, Master ");
            response.setDisplayText("Got brances");
            Data data = new Data();
            data.setAdditionalProperty("Branch list", request.getResult().getAction().toString());
            response.setData(data);
            List<Object> context = new ArrayList<>();
            context.add("deploycontext");
            response.setContextOut(context);
        }

        return response;
    }

    /* Get the list of available branches */
    /*@RequestMapping(value = "/branch", method = RequestMethod.GET)
    public List<String> getRelatedBraches(){
        List<String> availableBranches = new ArrayList<>();
        availableBranches.add("SPRINT-13_New_Feature_Dev");
        availableBranches.add("SPRINT-14_New_Feature_Enhance");
        availableBranches.add("SPRINT-13_New_Feature_Release");
        availableBranches.add("development");
        availableBranches.add("master");

        return availableBranches;
    }

    *//* Get the list of available environments *//*
    @RequestMapping(value = "/environment", method = RequestMethod.GET)
    public List<String> getEnvironment(){
        List<String> availableEnvironments = new ArrayList<>();
        availableEnvironments.add("Dev");
        availableEnvironments.add("QA");
        availableEnvironments.add("Prod");

        return availableEnvironments;
    }*/
}
