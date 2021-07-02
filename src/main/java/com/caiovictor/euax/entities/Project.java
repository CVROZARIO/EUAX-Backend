package com.caiovictor.euax.entities;

import com.caiovictor.euax.helpers.Consts;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
public class Project extends BaseEntity {

    @Column(length = 100, nullable = false)//, unique = true
    private String name;

    @Column(nullable = false)
    @JsonFormat(timezone=Consts.JSONFORMAT_DEFAULT_TIMEZONE)
    private Date dateBegin;

    @Column(nullable = false)
    @JsonFormat(timezone=Consts.JSONFORMAT_DEFAULT_TIMEZONE)
    private Date dateEnd;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<ProjectActivity> projectActivitySet;

    public Project() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<ProjectActivity> getProjectActivitySet() {
        return projectActivitySet;
    }

    public void setProjectActivitySet(Set<ProjectActivity> projectActivitySet) {
        this.projectActivitySet = projectActivitySet;
    }
}
