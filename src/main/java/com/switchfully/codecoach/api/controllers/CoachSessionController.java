package com.switchfully.codecoach.api.controllers;

import com.switchfully.codecoach.api.dtos.coachsessions.CoachSessionDTO;
import com.switchfully.codecoach.api.dtos.coachsessions.CreateCoachSessionDTO;
import com.switchfully.codecoach.api.mappers.CoachSessionMapper;
import com.switchfully.codecoach.service.CoachSessionService;
import com.switchfully.codecoach.service.TopicService;
import com.switchfully.codecoach.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/coachsessions")
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
}