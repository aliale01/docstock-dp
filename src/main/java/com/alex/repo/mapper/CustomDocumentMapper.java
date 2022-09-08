package com.alex.repo.mapper;

import static com.alex.repo.service.impl.AsposeDocConvertor.PATH;
import static com.alex.repo.service.impl.AsposeDocConvertor.PDF;

import com.alex.repo.dto.CustomDocumentDTO;
import com.alex.repo.models.CustomDocument;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomDocumentMapper {

    CustomDocumentMapper INSTANCE = Mappers.getMapper(CustomDocumentMapper.class);

    @Mapping(target = "path", source = "convertedFileName", qualifiedByName = "url")
    CustomDocumentDTO map(CustomDocument customDocument);

    List<CustomDocumentDTO> map(List<CustomDocument> customDocumentList);

    @Named("url")
    static String createPath(String convertedFileName) {
        return PATH + convertedFileName + PDF;
    }
}
