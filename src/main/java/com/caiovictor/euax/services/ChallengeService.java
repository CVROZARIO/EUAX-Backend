package com.caiovictor.euax.services;

import com.caiovictor.euax.entities.Project;
import com.caiovictor.euax.entities.ProjectActivity;
import com.caiovictor.euax.entities.ProjectStatus;

import java.util.List;

public interface ChallengeService {
    Project createProject(Project project) throws Exception;
    void deleteProjectById(long id) throws Exception;
    List<ProjectStatus> getProjectStatusList();
    List<Project> getProjectList();
    ProjectActivity createProjectActivity(ProjectActivity projectActivity) throws Exception;
    void deleteProjectActivityById(long id);
    List<ProjectActivity> getProjectActivityList();
}
