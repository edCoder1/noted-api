package com.noted.api.db;

import com.noted.api.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotebooksRepository extends JpaRepository<Notebook, UUID> {

}
