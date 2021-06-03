package com.switchfully.codecoach.api.controllers;

import com.switchfully.codecoach.api.dtos.coachsessions.CoachSessionDTO;
import com.switchfully.codecoach.api.dtos.coachsessions.CreateCoachSessionDTO;
import com.switchfully.codecoach.api.mappers.CoachSessionMapper;
import com.switchfully.codecoach.infrastructure.utils.ValidationUtil;
import com.switchfully.codecoach.service.CoachSessionService;
import com.switchfully.codecoach.service.TopicService;
import com.switchfully.codecoach.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/coachsessions")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://coach-potatos-codecoach.netlify.app")
public class CoachSessionController {

    private final CoachSessionMapper coachSessionMapper;
    private final CoachSessionService coachSessionService;
    private final UserService userService;
    private final TopicService topicService;
    private static final Logger logger = LoggerFactory.getLogger(CoachSessionController.class);

    public CoachSessionController(CoachSessionMapper coachSessionMapper, CoachSessionService coachSessionService, UserService userService, TopicService topicService) {
        this.coachSessionMapper = coachSessionMapper;
        this.coachSessionService = coachSessionService;
        this.userService = userService;
        this.topicService = topicService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CoachSessionDTO createSession(@RequestBody CreateCoachSessionDTO createCoachSessionDTO) {
        logger.info("New CoachSession created in controller: " + createCoachSessionDTO);
        return
                coachSessionMapper.mapCoachSessionToCoachSessionDTO(
                        coachSessionService.addCoachSession(
                                coachSessionMapper.mapCreateCoachSessionDTOToCoachSession(
                                        userService.getUserById(createCoachSessionDTO.getCoacheeId()), userService.getUserById(createCoachSessionDTO.getCoachId()),
                                        topicService.getTopicById(createCoachSessionDTO.getTopicId()),
                                        createCoachSessionDTO)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "/coach/{coachId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CoachSessionDTO> getCoachSessionsByCoachId(@PathVariable String coachId){
        return coachSessionMapper.mapCoachSessionListToCoachSessionDtoList(coachSessionService.getCoachSessionByCoachId(ValidationUtil.convertStringToUUID(coachId)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "/coachee/{coacheeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CoachSessionDTO> getCoachSessionsByCoacheeId(@PathVariable String coacheeId){
        return coachSessionMapper.mapCoachSessionListToCoachSessionDtoList(coachSessionService.getCoachSessionsByCoacheeId(ValidationUtil.convertStringToUUID(coacheeId)));
    }

    @PostMapping(path = "/{sessionId}/accept", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CoachSessionDTO acceptCoachSession(@PathVariable String sessionId ){
        return coachSessionMapper.mapCoachSessionToCoachSessionDTO(coachSessionService.acceptCoachSession(coachSessionService.getCoachSessionBySessionId(ValidationUtil.convertStringToUUID(sessionId))));
    }

    @PostMapping(path = "/{sessionId}/decline", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CoachSessionDTO declineCoachSession(@PathVariable String sessionId ){
        return coachSessionMapper.mapCoachSessionToCoachSessionDTO(coachSessionService.declineCoachSession(coachSessionService.getCoachSessionBySessionId(ValidationUtil.convertStringToUUID(sessionId))));
    }

}
