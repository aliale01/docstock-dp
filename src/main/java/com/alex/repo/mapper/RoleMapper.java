package com.alex.repo.mapper;

import com.alex.repo.dto.RoleDTO;
import com.alex.repo.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO roleToRoleDTO(Role role);

    List<RoleDTO> roleToRoleDTOList(List<Role> roleList);

    Role roleDTOToRole(RoleDTO roleDTO);
}
