package com.projectboard.service;

import com.projectboard.entity.ProjectTask;
import com.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {
    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask){
        if(projectTask.getStatus()==null || projectTask.getStatus()==""){
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> getProjectAll(){
        return projectTaskRepository.findAll();
    }

    public ProjectTask getProjectById(Long id){
        return projectTaskRepository.getById(id);
    }

    public void deleteProjectById(Long id){
        ProjectTask projectTask = projectTaskRepository.getById(id);
        if(projectTask != null){
            projectTaskRepository.deleteById(id);
        }
    }


}
