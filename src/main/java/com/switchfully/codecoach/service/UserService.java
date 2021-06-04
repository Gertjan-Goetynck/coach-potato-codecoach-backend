package com.switchfully.codecoach.service;

import com.switchfully.codecoach.domain.models.users.CoachProfile;
import com.switchfully.codecoach.domain.models.users.User;
import com.switchfully.codecoach.domain.repositories.RoleJPARepository;
import com.switchfully.codecoach.domain.repositories.UserJPARepository;
import com.switchfully.codecoach.infrastructure.exceptions.AlreadyCoachException;
import com.switchfully.codecoach.infrastructure.exceptions.EmailAlreadyTakenException;
import com.switchfully.codecoach.infrastructure.exceptions.InvalidLogInDetailsException;
import com.switchfully.codecoach.infrastructure.exceptions.UserNotFoundException;
import com.switchfully.codecoach.infrastructure.utils.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserJPARepository userJPARepository;
    private final RoleJPARepository roleRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserJPARepository userJPARepository, RoleJPARepository roleRepository) {
        this.userJPARepository = userJPARepository;
        this.roleRepository = roleRepository;
    }

    public User addUser(User user) {
        if (isEmailTaken(user.getEmail())) {
            throw new EmailAlreadyTakenException(user.getEmail());
        }
        logger.info("User added" + user.toString());
        user.addRole(roleRepository.getRoleByRoleType("Coachee"));
        return userJPARepository.save(user);
    }

    public User makeCoach(User user) {
        if (user.getRoles().contains(roleRepository.getRoleByRoleType("Coach"))) {
            throw new AlreadyCoachException();
        }
        logger.info("User is coach now" + user.toString());
        user.addRole(roleRepository.getRoleByRoleType("Coach"));

        user.setCoachProfile(new CoachProfile("", "", user.getId()));
        return user;
    }

    public User getUserById(String id) {
        logger.info("Fetching user with ID" + id);
        return userJPARepository.findById(ValidationUtil.convertStringToUUID(id)).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User logInWithEmailAndPassword(String email, String password) {
        email = email.toLowerCase();
        logger.info("Logging in with email " + email);
        User user = userJPARepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException(email);
        } else if (!password.equals(user.getPassword())) {
            throw new InvalidLogInDetailsException();
        } else return user;
    }

    public boolean isEmailTaken(String email) {
        return !ValidationUtil.isNull(userJPARepository.findByEmail(email));
    }
}
