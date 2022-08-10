package com.alex.repo.mapper;


import com.alex.repo.dto.UserDTO;
import com.alex.repo.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    List<UserDTO> userToUserDTOList(List<User> userList);

    User userDTOToUser(UserDTO userDTO);
}
