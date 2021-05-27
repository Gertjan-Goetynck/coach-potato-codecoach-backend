package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.users.CreateUserDTO;
import com.switchfully.codecoach.api.dtos.users.UserDTO;
import com.switchfully.codecoach.domain.models.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public UserDTO mapUserToDto(User user){
        logger.info("Mapping a User to UserDTO, returning a UserDTO");
        return new UserDTO()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setPictureUrl(user.getPictureUrl())
                .setCoachProfile(coachProfileMapper.mapCoachProfileToCoachProfileDTO(user.getCoachProfile()))
                .setRoles(rolesMapper.mapRoleListToRoleDTOList(user.getRoles()));
    }

    public List<UserDTO> mapListUsersToListUserDtos(List<User> listUsers) {
        logger.info("Mapping a list of Users to a List of UserDTOs");
        return listUsers.stream().map(this::mapUserToDto).collect(Collectors.toList());
    }
}
