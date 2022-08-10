package com.alex.repo.mapper;

import com.alex.repo.dto.FileDTO;
import com.alex.repo.models.File;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper {

    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

    FileDTO fileToFileDTO(File file);

    List<FileDTO> fileToFileDTOList(List<File> fileList);

    File fileDTOToFile(FileDTO fileDTO);
}
