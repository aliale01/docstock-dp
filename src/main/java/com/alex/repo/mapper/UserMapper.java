package com.alex.repo.mapper;


import com.alex.repo.dto.UserDTO;
import com.alex.repo.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    List<UserDTO> userToUserDTOList(List<User> userList);

    User userDTOToUser(UserDTO userDTO);
}
