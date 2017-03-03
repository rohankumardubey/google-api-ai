package com.build.assistant.rest;

import com.build.assistant.domain.Data;
import com.build.assistant.domain.Request;
import com.build.assistant.domain.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class BaseController {
    final org.slf4j.Logger log = LoggerFactory.getLogger(BaseController.class);

    /* Deploy the application */
    @RequestMapping(value = "/deploy", method = RequestMethod.POST)
    @ResponseBody
    public Response deployApplication(@RequestBody Request request){
        Response response = new Response();

        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Request incoming " + mapper.writeValueAsString(request));
            log.info("Recieved Request 1");
            log.info("Recieved Request 1 Action: " + request.getResult().getAction().toString());
            if (request != null && request.getResult() != null && request.getResult().getAction().equals("deploy")) {

                response.setSpeech(" Successfully deployed ");
                response.setDisplayText("Display Successfully Deployed");
                Data data = new Data();
                data.setAdditionalProperty("Depployed", request.getResult().getAction().toString());
                response.setData(data);
                List<Object> context = new ArrayList<>();
                context.add("deploycontext");
                response.setContextOut(context);
            } else if (request != null && request.getResult() != null && request.getResult().getAction().equals("getBranches")) {
                response.setSpeech(" List of Branches is Dev, Master ");
                response.setDisplayText("Got brances");
                Data data = new Data();
                data.setAdditionalProperty("Branch list", request.getResult().getAction().toString());
                response.setData(data);
                List<Object> context = new ArrayList<>();
                context.add("deploycontext");
                response.setContextOut(context);
            }
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }

        log.info("Sending Response");

        return response;
    }


    @RequestMapping(value = "/deploy1", method = RequestMethod.POST)
    @ResponseBody
    public Response deployApplication1(@RequestBody String request1){
        Response response = new Response();
        response.setSpeech(" Successfully deployed ");
                response.setDisplayText("Display Successfully Deployed");
                Data data = new Data();
                data.setAdditionalProperty("Depployed", "test");
                response.setData(data);
                List<Object> context = new ArrayList<>();
                context.add("deploycontext");
                response.setContextOut(context);

        log.info("Sending Response");

        return response;
    }


    @RequestMapping(value = "/deploy2", method = RequestMethod.POST)
    @ResponseBody
    public Response deployApplication2(@RequestBody String request1){
        Response response = new Response();

                response.setSpeech(" List of Branches is Dev, Master ");
                response.setDisplayText("Got brances");
                Data data = new Data();
                data.setAdditionalProperty("Branch list", "ttttt");
                response.setData(data);
                List<Object> context = new ArrayList<>();
                context.add("deploycontext");
                response.setContextOut(context);

        log.info("Sending Response");

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
