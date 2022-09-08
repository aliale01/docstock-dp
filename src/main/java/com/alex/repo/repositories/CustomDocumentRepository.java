package com.alex.repo.repositories;

import com.alex.repo.models.CustomDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomDocumentRepository extends JpaRepository<CustomDocument, String> {

}
