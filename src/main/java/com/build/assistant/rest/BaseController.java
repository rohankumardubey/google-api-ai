package com.build.assistant.rest;

import com.build.assistant.Model.Attendees;
import com.build.assistant.Model.Sessions;
import com.build.assistant.Repo.AttendeeRepo;
import com.build.assistant.Repo.SessionsRepo;
import com.build.assistant.domain.Data;
import com.build.assistant.domain.Request;
import com.build.assistant.domain.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class BaseController {

    @Autowired
    AttendeeRepo attendeeRepo;

    @Autowired
    SessionsRepo sessionsRepo;

    final org.slf4j.Logger log = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping(value = "/getName", method = RequestMethod.POST)
    @ResponseBody
    public Response deployApplication(@RequestBody Request request){
        Response response = new Response();
        Data data = new Data();
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("Request incoming " + mapper.writeValueAsString(request));
            log.info("Request incoming " + mapper.writeValueAsString(request));
            log.info("Recieved Request 1 Action: " + request.getResult().getAction().toString());
            if (request != null && request.getResult() != null && request.getResult().getParameters().getAdditionalProperties() != null &&
                    request.getResult().getParameters().getAdditionalProperties().get("number") != null && request.getResult().getAction().equals("getName")) {

                log.info(request.getResult().getParameters().getAdditionalProperties().get("number").toString());

                Attendees attendees = attendeeRepo.findByTicketNumber(request.getResult().getParameters().getAdditionalProperties().get("number").toString());

                if (attendees != null && attendees.getName() != null && !attendees.getName().equals("")) {
                    String name = attendees.getName();
                    data.setAdditionalProperty("name", name);
                    response.setSpeech(" Hello " + name + " , your registration is confirm, Welcome to Pune Data Conference!! What topics you are interested in, i may suggest you few relevant sessions");
                    response.setDisplayText(" Hello " + name + "  , your registration is confirm, Welcome to Pune Data Conference!! What topics you are interested in, i may suggest you few relevant sessions");
                    response.setData(data);
                    log.info("got the name " + name);
                } else {
                    response.setSpeech("Unable to find ticket number can you please try again!!");
                    response.setDisplayText("Unable to find ticket number can you please try again!!");
                    log.info("Name is not available or missing ");
                }
            } else if (request != null && request.getResult() != null && request.getResult().getParameters().getAdditionalProperties() != null &&
                    request.getResult().getAction().equals("getName")) {
                response.setSpeech("Unable to find ticket number can you please try again!!");
                response.setDisplayText("Unable to find ticket number can you please try again!!");
                log.info("unable to get name ");
            } else if (request != null && request.getResult() != null && request.getResult().getParameters().getAdditionalProperties() != null &&
                    request.getResult().getParameters().getAdditionalProperties().get("tags") != null && request.getResult().getAction().equals("getSchedule")) {

                log.info(request.getResult().getParameters().getAdditionalProperties().get("tags").toString());
                String[] listOfTags = request.getResult().getParameters().getAdditionalProperties().get("tags").toString().split(",");
                List<Sessions> sessionses = sessionsRepo.findAll();

                if (sessionses != null && sessionses.size() > 0) {
                    List<String> sessionsTitles = new ArrayList<>();
                    for (Sessions sessions : sessionses) {
                        for (String tag : listOfTags) {
                            String[] tagsOnSession = sessions.getTags().split(",");
                            for (String tagString : tagsOnSession) {
                                if (tagString.equalsIgnoreCase(tag)) {
                                    sessionsTitles.add(", Speaker " + sessions.getSpeaker() + " will be talking about " + sessions.getTitle());
                                }
                            }
                        }
                    }

                    if (!sessionsTitles.isEmpty()) {
                        data.setAdditionalProperty("sessions", String.join(",", sessionsTitles));
                        response.setSpeech(" Here is the list of the sessions you may in intersted in : " + String.join(",", sessionsTitles) + "Is there anything else I can help with?");
                        response.setDisplayText(" Here is the list of the sessions you may in intersted in : " + String.join(",", sessionsTitles) + "Is there anything else I can help with?");
                        response.setData(data);
                    } else {
                        response.setSpeech("Unable to find any sessions with provided input, Possible topics can be AI, ML, IOT, Analytics, streaming etc ");
                        response.setDisplayText("Unable to find any sessions with provided input, Possible topics can be AI, ML, IOT, Analytics, streaming etc ");
                        log.info("Unable to find any sessions with provided input, Possible topics can be AI, ML, IOT, Analytics, streaming etc ");
                    }
                }
                List<Object> context = new ArrayList<>();
                response.setContextOut(context);
            } else {
                response.setSpeech("Something is not good with me, can you please try again");
                response.setDisplayText("Something is not good with me, can you please try again");
                log.info("Something is not good with me, can you please try again");
            }
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        try {
            log.info("Sending Response " + mapper.writeValueAsString(response));
        }catch(Exception e){
            log.info("Unable to read response", e);
        }

        return response;
    }

    @RequestMapping(value = "/getAllAttendees", method = RequestMethod.GET)
    @ResponseBody
    public List<Attendees> getDetails(){
        List<Attendees> attendeeList = attendeeRepo.findAll();
        return attendeeList;
    }
}
