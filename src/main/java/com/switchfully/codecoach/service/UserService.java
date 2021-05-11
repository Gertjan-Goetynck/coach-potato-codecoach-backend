package com.switchfully.codecoach.service;

import com.switchfully.codecoach.api.controllers.UserController;
import com.switchfully.codecoach.domain.models.users.User;
import com.switchfully.codecoach.domain.repositories.UserJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserJPARepository userJPARepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    public User addUser(User user){
        logger.info("User added" + user.toString());
        return userJPARepository.save(user);
    }
}
