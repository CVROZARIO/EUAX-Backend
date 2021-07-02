package com.caiovictor.euax.entities;

import java.util.Calendar;

/*
 * CLASSE SEPARADA PARA DAR MAIS ESCALABILIDADE A PROPOSTA DE STATUS DOS PROJETOS
 * PERMITINDO MAIS ATRIBUTOS, RELAÇÕES, INTERPRETAÇÕES...
 */
public class ProjectStatus {

    private Project project;
    private long activityCount;
    private double percentFinished;
    private boolean isDelayed;

    public ProjectStatus(Project project) {
        this.setProject(project);
        this.setActivityCount(project.getProjectActivitySet().size());
        if(this.getActivityCount() > 0){
            this.setPercentFinished(
                    (project.getProjectActivitySet().stream().filter(ProjectActivity::getFinished).count() * 1d)
                                    /this.getActivityCount()
                                    *100d
            );
        }
        if(this.getPercentFinished() < 100 && project.getDateEnd().before(Calendar.getInstance().getTime())){
            this.setDelayed(true);
        }
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public long getActivityCount() {
        return activityCount;
    }

    public void setActivityCount(long activityCount) {
        this.activityCount = activityCount;
    }

    public double getPercentFinished() {
        return percentFinished;
    }

    public void setPercentFinished(double percentFinished) {
        this.percentFinished = percentFinished;
    }

    public boolean isDelayed() {
        return isDelayed;
    }

    public void setDelayed(boolean delayed) {
        isDelayed = delayed;
    }
}
