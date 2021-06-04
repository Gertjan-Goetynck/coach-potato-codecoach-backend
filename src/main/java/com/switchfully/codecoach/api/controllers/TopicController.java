package com.switchfully.codecoach.api.controllers;

import com.switchfully.codecoach.api.dtos.topics.TopicDTO;
import com.switchfully.codecoach.api.mappers.TopicMapper;
import com.switchfully.codecoach.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/topics")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://coach-potatos-codecoach.netlify.app")
public class TopicController {

    private final TopicService topicService;
    private final TopicMapper topicMapper;
    private static final Logger logger = LoggerFactory.getLogger(TopicController.class);


    public TopicController(TopicService topicService, TopicMapper topicMapper) {
        this.topicService = topicService;
        this.topicMapper = topicMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<TopicDTO> getAllTopics() {
        logger.info("Getting all topics");
        return topicMapper.mapListTopicsToListTopicDtos(topicService.getTopics());
    }
}
