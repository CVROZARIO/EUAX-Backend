package com.caiovictor.euax.repositories;


import com.caiovictor.euax.entities.ProjectActivity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectActivityRepository extends CrudRepository<ProjectActivity, Long> {
    ProjectActivity[] findByProjectId(Long projectId);
}