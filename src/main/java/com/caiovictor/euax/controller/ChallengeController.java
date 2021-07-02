package com.caiovictor.euax.controller;

import com.caiovictor.euax.entities.Project;
import com.caiovictor.euax.entities.ProjectActivity;
import com.caiovictor.euax.entities.ProjectStatus;
import com.caiovictor.euax.entities.SimpleKeyValue;
import com.caiovictor.euax.services.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @RequestMapping("/")
    public List<SimpleKeyValue> getApiIndex() {
        List<SimpleKeyValue> pairs = new ArrayList<>();
        pairs.add(new SimpleKeyValue("/project/create", "[POST] Cadastro de Projeto"));
        pairs.add(new SimpleKeyValue("/project/delete", "[POST] Deleção de Projeto"));
        pairs.add(new SimpleKeyValue("/project/status", "[GET] Lista de Projetos Cadastrados e seus Status"));
        pairs.add(new SimpleKeyValue("/project/list", "[GET] Lista de Projetos Cadastrados"));
        pairs.add(new SimpleKeyValue("/project/activity/create", "[POST] Cadastro de Atividade de Projeto"));
        pairs.add(new SimpleKeyValue("/project/activity/delete", "[POST] Deleção de Atividade de Projeto"));
        pairs.add(new SimpleKeyValue("/project/activity/list", "[GET] Lista de Atividades de Projetos Cadastrados"));
        return pairs;
    }

    @PostMapping("/project/create")
    public Project createProject(@RequestBody Project project) throws Exception {
        return challengeService.createProject(project);
    }

    @PostMapping("/project/delete")
    public void deleteProjectById(@RequestBody long id) throws Exception {
        challengeService.deleteProjectById(id);
    }

    @GetMapping("/project/status")
    public List<ProjectStatus> getProjectStatusList() {
        return challengeService.getProjectStatusList();
    }

    @GetMapping("/project/list")
    public List<Project> getProjectList() {
        return challengeService.getProjectList();
    }

    @PostMapping("/project/activity/create")
    public ProjectActivity createProjectActivity(@RequestBody ProjectActivity projectActivity) throws Exception {
        return challengeService.createProjectActivity(projectActivity);
    }

    @PostMapping("/project/activity/delete")
    public void deleteProjectActivityById(@RequestBody long id) {
        challengeService.deleteProjectActivityById(id);
    }

    @GetMapping("/project/activity/list")
    public List<ProjectActivity> getProjectActivityList() {
        return challengeService.getProjectActivityList();
    }

}
