package com.gjsm.taskmanager.service;

import com.gjsm.taskmanager.vo.Tasks;

import java.util.List;

public interface TaskManagerService {
	
	public List<Tasks> fetchTasks();
	public void updateTask(Tasks task);
	public Tasks getTask(Long taskID);

}
