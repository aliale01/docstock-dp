package com.alex.repo.mapper;

import com.alex.repo.dto.FileDTO;
import com.alex.repo.models.File;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper {

    FileDTO fileToFileDTO(File file);

    List<FileDTO> fileToFileDTOList(List<File> fileList);

    File fileDTOToFile(FileDTO fileDTO);
}
