package com.gjsm.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gjsm.taskmanager.service.TaskManagerService;
import com.gjsm.taskmanager.vo.Tasks;

@RestController
public class TaskManagerController {
	
	@Autowired
	private TaskManagerService taskManagerService;
	

	public void setTaskManagerService(TaskManagerService taskManagerService) {
		this.taskManagerService=taskManagerService;
	}
	
	@GetMapping("/taskmanagerapp/alltasks")
    public List<Tasks> getTasks() {
        List<Tasks> tasks = taskManagerService.fetchTasks();
        return tasks;
    }
	
	 @GetMapping("/taskmanagerapp/gettask/{taskID}")
     public Tasks getTask(@PathVariable(name="taskID") Long taskID) {
         Tasks task = taskManagerService.getTask(taskID);
         return task;

     }
	 
	 @PostMapping(path = "/taskmanagerapp/savetasks", consumes = "application/json", produces = "application/json")
     public boolean saveTask(@RequestBody Tasks task) {
         try {
             taskManagerService.updateTask(task);
         }catch(Exception e)
         {
             System.out.println("Task save failure: " + e.getMessage());
             return false;
         }
         return true;
     }
	 
	 @PutMapping("/taskmanagerapp/updatetasks/{taskID}")
     public boolean updateTask(@RequestBody Tasks task, @PathVariable(name="taskID") Long taskID) {
         try {
                 Tasks taskFound = taskManagerService.getTask(taskID);
                 if(taskFound != null) {
                         taskManagerService.updateTask(task);
                 }else {
                         System.out.println("No tasks to update: " + taskID);
                         return false;
                 }
         }catch(Exception e)
         {
             System.out.println("Task update failure: " + e.getMessage());
             return false;
         }

         return true;
     }
	 
	  @DeleteMapping("/taskmanagerapp/deletetasks/{taskID}")
      public boolean deleteTask(@PathVariable(name="taskID") Long taskID) {
          try {
                  Tasks taskFound = taskManagerService.getTask(taskID);
                  if(taskFound != null) {
                	  taskFound.setTaskStatus("Inactive");
                      taskManagerService.updateTask(taskFound);
                  }else {
                      System.out.println("No tasks to delete: " + taskID);
                      return false;
                  }
          }catch(Exception e)
          {
              System.out.println("Task delete failure: " + e.getMessage());
              return false;
          }
          return true;
      }
}
