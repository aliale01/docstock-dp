package com.alex.repo.mapper;


import com.alex.repo.dto.UserDTO;
import com.alex.repo.models.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO map(User user);

    List<UserDTO> map(List<User> userList);

    User map(UserDTO userDTO);
}
