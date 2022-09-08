package com.alex.repo.mapper;

import com.alex.repo.dto.RoleDTO;
import com.alex.repo.models.Role;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO map(Role role);

    List<RoleDTO> map(List<Role> roleList);

    Role map(RoleDTO roleDTO);
}
