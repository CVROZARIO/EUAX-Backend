package com.caiovictor.euax.entities;

import com.caiovictor.euax.helpers.Consts;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class ProjectActivity extends BaseEntity {

    @Column(length = 100, nullable = false)//, unique = true
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Project project;

    @Column(nullable = false)
    @JsonFormat(timezone=Consts.JSONFORMAT_DEFAULT_TIMEZONE)
    private Date dateBegin;

    @Column(nullable = false)
    @JsonFormat(timezone=Consts.JSONFORMAT_DEFAULT_TIMEZONE)
    private Date dateEnd;

    @Column(nullable = false)
    private Boolean isFinished = false;

    public ProjectActivity() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }
}
