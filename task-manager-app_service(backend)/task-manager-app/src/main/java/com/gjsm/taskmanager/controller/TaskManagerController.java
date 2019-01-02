package com.gjsm.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.gjsm.taskmanager.service.TaskManagerService;
import com.gjsm.taskmanager.vo.Tasks;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TaskManagerController {
	
	@Autowired
	private TaskManagerService taskManagerService;
	

	@RequestMapping(value="/addTask", method = RequestMethod.POST, produces = "application/json")
  	@ResponseBody
  	public String addTask(@RequestBody Tasks task) {
		taskManagerService.addTask(task);
  		return "TASK ADDED SUCCESSFULLY";
  	}
  		
  	@RequestMapping(value="/viewTask", method = RequestMethod.GET, produces = "application/json")
  	public @ResponseBody List<Tasks> viewtask() {
  		return taskManagerService.getAllTasks();
  	}
  	
  	@RequestMapping(value="/deleteTask/{taskId}", method = RequestMethod.GET, produces = "application/json")
  	public @ResponseBody List<Tasks> deleteTask(@PathVariable int taskId) {
  		return taskManagerService.deleteTask(taskId);
  	}
  	
  	@RequestMapping(value="/updateTask", method = RequestMethod.POST, produces = "application/json")
  	@ResponseBody
  	public String updateTask(@RequestBody Tasks task) {
  		taskManagerService.editTask(task);
  		return "TASK UPDATED SUCCESSULLY";
  	}

 }
