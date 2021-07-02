package com.caiovictor.euax.services;

import com.caiovictor.euax.entities.Project;
import com.caiovictor.euax.entities.ProjectActivity;
import com.caiovictor.euax.entities.ProjectStatus;
import com.caiovictor.euax.repositories.ProjectActivityRepository;
import com.caiovictor.euax.repositories.ProjectRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectActivityRepository projectActivityRepository;

    @Override
    public Project createProject(Project project) throws Exception {
        if(project.getDateEnd().before(project.getDateBegin())){
            throw new Exception("A data de conclusão não pode ser menor que a data de início.");
        }
        return projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(long id) throws Exception {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com ID: " + id));
        ProjectActivity[] projectActivity = projectActivityRepository.findByProjectId(id);
        if(projectActivity.length > 0){
            throw new Exception("Primeiramento você deve remover as atividades deste projeto.");
        }
        projectRepository.delete(project);
    }

    @Override
    public List<ProjectStatus> getProjectStatusList() {
        return StreamSupport.stream(projectRepository.findAll().spliterator(), false)
                .map(ProjectStatus::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Project> getProjectList() {
        return StreamSupport.stream(projectRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectActivity createProjectActivity(ProjectActivity projectActivity) throws Exception {
        if(projectActivity.getDateEnd().before(projectActivity.getDateBegin())){
            throw new Exception("A data de conclusão não pode ser menor que a data de início.");
        }
        Project project = projectRepository.findById(projectActivity.getProject().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com ID: " + projectActivity.getProject().getId()));
        if(projectActivity.getDateBegin().before(project.getDateBegin())) {
            throw new Exception("A data de início da atividade não pode ser menor que a data de início do projeto.");
        }else if(projectActivity.getDateEnd().after(project.getDateEnd())){
            throw new Exception("A data de conclusão da atividade não pode ser maior que a data de conclusão do projeto.");
        }
        projectActivity.setProject(project);
        return projectActivityRepository.save(projectActivity);
    }

    @Override
    public void deleteProjectActivityById(long id) {
        ProjectActivity projectActivity = projectActivityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atividade não encontrada com ID: " + id));
        projectActivityRepository.delete(projectActivity);
    }

    @Override
    public List<ProjectActivity> getProjectActivityList() {
        return StreamSupport.stream(projectActivityRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
