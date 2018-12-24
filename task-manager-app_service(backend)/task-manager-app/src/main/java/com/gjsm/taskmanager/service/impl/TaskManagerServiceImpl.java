package com.gjsm.taskmanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gjsm.taskmanager.service.TaskManagerService;
import com.gjsm.taskmanager.vo.Tasks;
import com.gjsm.taskmanager.jparepo.TaskManagerJpaRepo;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {

	@Autowired
	private TaskManagerJpaRepo taskManagerJpaRepo;
	
	public List<Tasks> fetchTasks() {
		List<Tasks> tasks = taskManagerJpaRepo.findAll();
		return tasks;
	}

	public void updateTask(Tasks task) {
		taskManagerJpaRepo.save(task);
		
	}

	public Tasks getTask(Long taskID) {
		Optional<Tasks> task = taskManagerJpaRepo.findById(taskID);
 		return task.get();
	}
	
	

}
