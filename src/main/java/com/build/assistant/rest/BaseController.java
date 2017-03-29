package com.build.assistant.rest;

import com.build.assistant.Model.Attendees;
import com.build.assistant.Repo.AttendeeRepo;
import com.build.assistant.domain.Data;
import com.build.assistant.domain.Request;
import com.build.assistant.domain.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class BaseController {

    @Autowired
    AttendeeRepo attendeeRepo;

    final org.slf4j.Logger log = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping(value = "/getName", method = RequestMethod.POST)
    @ResponseBody
    public Response deployApplication(@RequestBody Request request){
        Response response = new Response();
        Data data = new Data();
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Request incoming " + mapper.writeValueAsString(request));
            log.info("Request incoming " + mapper.writeValueAsString(request));
            log.info("Recieved Request 1 Action: " + request.getResult().getAction().toString());
            if (request != null && request.getResult() != null && request.getResult().getParameters().getAdditionalProperties() != null &&
                    request.getResult().getParameters().getAdditionalProperties().get("number") != null && request.getResult().getAction().equals("getName")) {

                log.info(request.getResult().getParameters().getAdditionalProperties().get("number").toString());

                Attendees attendees = attendeeRepo.findByTicketNumber(request.getResult().getParameters().getAdditionalProperties().get("number").toString());

                if(attendees != null && attendees.getName() != null && !attendees.getName().equals("")) {
                    String name = attendees.getName();
                    data.setAdditionalProperty("name", name);
                    response.setSpeech(" Hello " + name + " , your registration is confirm, Welcome to Pune Data Conference!!");
                    response.setDisplayText(" Hello " + name+ "  , your registration is confirm, Welcome to Pune Data Conference!!");
                    response.setData(data);
                }else{
                    response.setSpeech("Unable to find ticket number can you please try again!!");
                    response.setDisplayText("Unable to find ticket number can you please try again!!");
                }
            }else{
                response.setSpeech("Unable to find ticket number can you please try again!!");
                response.setDisplayText("Unable to find ticket number can you please try again!!");
            }
            List<Object> context = new ArrayList<>();
            context.add("getName");
            response.setContextOut(context);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }

        log.info("Sending Response");

        return response;
    }

    @RequestMapping(value = "/getAllAttendees", method = RequestMethod.GET)
    @ResponseBody
    public List<Attendees> getDetails(){
        List<Attendees> attendeeList = attendeeRepo.findAll();
        return attendeeList;
    }
}
