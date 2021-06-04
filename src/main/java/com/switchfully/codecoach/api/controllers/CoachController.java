package com.switchfully.codecoach.api.controllers;

import com.switchfully.codecoach.api.dtos.coachprofiles.UpdateCoachProfileDTO;
import com.switchfully.codecoach.api.dtos.coachtopics.CreateCoachTopicDTO;
import com.switchfully.codecoach.api.dtos.users.UserDTO;
import com.switchfully.codecoach.api.mappers.CoachTopicMapper;
import com.switchfully.codecoach.api.mappers.UserMapper;
import com.switchfully.codecoach.service.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/coaches")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://coach-potatos-codecoach.netlify.app")
public class CoachController {

    private final CoachTopicMapper coachTopicMapper;
    private final CoachService coachService;
    private final UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(CoachController.class);

    public CoachController(CoachTopicMapper coachTopicMapper, CoachService coachService, UserMapper userMapper) {
        this.coachTopicMapper = coachTopicMapper;
        this.coachService = coachService;
        this.userMapper = userMapper;
    }

    @PutMapping(path = "/{coachId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO addTopicToCoach(@RequestParam String coachId, @RequestBody CreateCoachTopicDTO coachTopic) {
        logger.info("Adding topics " + coachTopic + " to coach with id " + coachId);
        return userMapper.mapUserToDto(this.coachService.setCoachTopic(coachId,coachTopic));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getCoaches(){
        logger.info("Get All Coaches");
        return userMapper.mapListUsersToListUserDtos(this.coachService.getCoaches());
    }

    @GetMapping(path = "/{coachId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getCoachById(@PathVariable String coachId) {
        logger.info("Get Coach With Id" + coachId);
        return userMapper.mapUserToDto(this.coachService.getCoachById(coachId));
    }

    @PutMapping(path = "/{coachId}/updateprofile", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateCoachProfile(@PathVariable String coachId, @RequestBody UpdateCoachProfileDTO updateCoachProfileDTO){
        logger.info("Updating profile of coach with id " + coachId);
        return userMapper.mapUserToDto(this.coachService.editCoachById(coachId, updateCoachProfileDTO));
    }

}
