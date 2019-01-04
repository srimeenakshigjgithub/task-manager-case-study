package com.gjsm.taskmanager.service;

import com.gjsm.taskmanager.vo.Tasks;

import java.util.List;

public interface TaskManagerService {
	
	public void addTask(Tasks task);
	public List<Tasks> deleteTask(int task_id);
	public void editTask(Tasks task);
	public List<Tasks> getAllTasks();

}
