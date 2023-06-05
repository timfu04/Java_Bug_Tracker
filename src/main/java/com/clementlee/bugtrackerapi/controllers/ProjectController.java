package com.clementlee.bugtrackerapi.controllers;

import com.clementlee.bugtrackerapi.dto.ProjectDTO;
import com.clementlee.bugtrackerapi.services.impl.ProjectServiceImpl;
import com.clementlee.bugtrackerapi.validation.markerinterface.ProjectAllFieldsValidationGroup;
import com.clementlee.bugtrackerapi.validation.markerinterface.ProjectDateValidationGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    @PostMapping("user/{userId}/project/create")
    public ResponseEntity<ProjectDTO> createProjectByUserId(@PathVariable(value = "userId") int userId,
                                                            @Validated(ProjectAllFieldsValidationGroup.class) @RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(projectServiceImpl.createProjectByUserId(userId, projectDTO), HttpStatus.CREATED);
    }

    @GetMapping("user/{userId}/project")
    public ResponseEntity<List<ProjectDTO>> getAllProjectsByUserId(@PathVariable(value = "userId") int userId){
        return new ResponseEntity<>(projectServiceImpl.getAllProjectsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("user/{userId}/project/{projectId}")
    public ResponseEntity<ProjectDTO> getProjectByUserIdByProjectId(@PathVariable(value = "userId") int userId,
                                                                    @PathVariable(value = "projectId") int projectId){
        return new ResponseEntity<>(projectServiceImpl.getProjectByUserIdByProjectId(userId, projectId), HttpStatus.OK);
    }

    @PutMapping("user/{userId}/project/{projectId}/update-full")
    public ResponseEntity<ProjectDTO> updateProjectFullByUserIdByProjectId(@PathVariable(value = "userId") int userId,
                                                                           @PathVariable(value = "projectId") int projectId,
                                                                           @Validated(ProjectAllFieldsValidationGroup.class) @RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(projectServiceImpl.updateProjectFullByUserIdByProjectId(userId, projectId, projectDTO), HttpStatus.OK);
    }

    @PatchMapping("user/{userId}/project/{projectId}/update-partial")
    public ResponseEntity<ProjectDTO> updateProjectPartialByUserIdByProjectId(@PathVariable(value = "userId") int userId,
                                                                              @PathVariable(value = "projectId") int projectId,
                                                                              @Validated(ProjectDateValidationGroup.class) @RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(projectServiceImpl.updateProjectPartialByUserIdByProjectId(userId, projectId, projectDTO), HttpStatus.OK);
    }

    @DeleteMapping("user/{userId}/project/{projectId}/delete")
    public ResponseEntity<String> deleteProjectByUserIdByProjectId(@PathVariable(value = "userId") int userId,
                                                                   @PathVariable(value = "projectId") int projectId){
        projectServiceImpl.deleteProjectByUserIdByProjectId(userId, projectId);
        return ResponseEntity.ok("Project deleted successfully");
    }

    @GetMapping("project")
    public ResponseEntity<List<ProjectDTO>> getAllProjects(){
        return new ResponseEntity<>(projectServiceImpl.getAllProjects(), HttpStatus.OK);
    }

    @PutMapping("project/{projectId}/update-full")
    public ResponseEntity<ProjectDTO> updateProjectFullByProjectId(@PathVariable(value = "projectId") int projectId,
                                                                   @Validated(ProjectAllFieldsValidationGroup.class) @RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(projectServiceImpl.updateProjectFullByProjectId(projectId, projectDTO), HttpStatus.OK);
    }

    @PatchMapping("project/{projectId}/update-partial")
    public ResponseEntity<ProjectDTO> updateProjectPartialByProjectId(@PathVariable(value = "projectId") int projectId,
                                                                      @Validated(ProjectDateValidationGroup.class) @RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(projectServiceImpl.updateProjectPartialByProjectId(projectId, projectDTO), HttpStatus.OK);
    }

    @DeleteMapping("project/{projectId}/delete")
    public ResponseEntity<String> deleteProjectByProjectId(@PathVariable(value = "projectId") int projectId){
        projectServiceImpl.deleteProjectByProjectId(projectId);
        return ResponseEntity.ok("Project deleted successfully");
    }


}
