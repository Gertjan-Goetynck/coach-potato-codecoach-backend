package com.switchfully.codecoach.service;

import com.switchfully.codecoach.domain.models.users.User;
import com.switchfully.codecoach.domain.repositories.RoleRepository;
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
    private final RoleRepository roleRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserJPARepository userJPARepository, RoleRepository roleRepository) {
        this.userJPARepository = userJPARepository;
        this.roleRepository = roleRepository;
    }

    public User addUser(User user){
        logger.info("User added" + user.toString());
        user.addRole(roleRepository.getRoleByRoleType("Coachee"));
        return userJPARepository.save(user);
    }

}
