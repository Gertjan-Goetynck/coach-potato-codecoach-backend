package com.switchfully.codecoach.service;

import com.switchfully.codecoach.domain.models.users.User;
import com.switchfully.codecoach.domain.repositories.RoleRepository;
import com.switchfully.codecoach.domain.repositories.UserJPARepository;
import com.switchfully.codecoach.infrastructure.exceptions.EmailAlreadyTakenException;
import com.switchfully.codecoach.infrastructure.utils.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ValidationUtils;

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

    public User addUser(User user) {
        if(isEmailTaken(user.getEmail())){
            throw new EmailAlreadyTakenException(user.getEmail());
        }
        logger.info("User added" + user.toString());
        user.addRole(roleRepository.getRoleByRoleType("Coachee"));
        return userJPARepository.save(user);
    }

    public boolean isEmailTaken(String email) {
        return !ValidationUtil.isNull(userJPARepository.findByEmail(email));
    }
}
