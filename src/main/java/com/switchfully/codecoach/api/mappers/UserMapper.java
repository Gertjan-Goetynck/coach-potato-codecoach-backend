package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.users.CreateUserDTO;
import com.switchfully.codecoach.api.dtos.users.UserDTO;
import com.switchfully.codecoach.domain.models.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final CoachProfileMapper coachProfileMapper;
    private final RolesMapper rolesMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

    public UserMapper(CoachProfileMapper coachProfileMapper, RolesMapper rolesMapper) {
        this.coachProfileMapper = coachProfileMapper;
        this.rolesMapper = rolesMapper;
    }

    public User mapCreateUserDtoToUser(CreateUserDTO createUserDTO){
        logger.info("Mapping a CreateUserDTO to a User, returning a User");
        return new User(createUserDTO.getFirstName(),
                createUserDTO.getLastName(),
                createUserDTO.getEmail(),
                createUserDTO.getPassword(),
                createUserDTO.getPictureUrl()
                );
    }

//    public User mapUserDTOToUser(UserDTO userDTO){
//        logger.info("Mapping a UserDTO to a User, returning a User");
//        return new User(userDTO.getId().toString(),
//                userDTO.getFirstname(),
//                userDTO.getLastname(),
//                userDTO.getEmail(),
//                userDTO.getPictureUrl());
//    }

    public UserDTO mapUserToDto(User user){
        logger.info("Mapping a User to UserDTO, returning a UserDTO");
        return new UserDTO()
                .setId(user.getId())
                .setFirstname(user.getFirstName())
                .setLastname(user.getLastName())
                .setEmail(user.getEmail())
                .setPictureUrl(user.getPictureUrl())
                .setCoachProfile(coachProfileMapper.mapCoachProfileToCoachProfileDTO(user.getCoachProfile()))
                .setRoles(rolesMapper.mapRoleListToRoleDTOList(user.getRoles()));
    }
}
