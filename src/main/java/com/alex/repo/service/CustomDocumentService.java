package com.alex.repo.service;

import com.alex.repo.models.CustomDocument;
import com.alex.repo.models.User;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface CustomDocumentService {

    List<CustomDocument> getAllDocuments(User user);

    CustomDocument update(CustomDocument customDocument);

    CustomDocument create(CustomDocument customDocument);

    CustomDocument getById(String id);

    void delete(String id);

    CustomDocument createDocument(MultipartFile file, String timestamp, String description, String convertedFileName, String username);

    Resource downloadFile(String id);
}
