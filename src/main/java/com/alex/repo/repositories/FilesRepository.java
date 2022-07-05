package com.alex.repo.repositories;

import com.alex.repo.models.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files,Long> {
}
