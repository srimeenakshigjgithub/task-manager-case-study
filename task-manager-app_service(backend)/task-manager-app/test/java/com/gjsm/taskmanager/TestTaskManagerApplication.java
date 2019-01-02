package com.gjsm.taskmanager;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gjsm.taskmanager.service.impl.TaskManagerServiceImpl;
import com.gjsm.taskmanager.vo.Tasks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTaskManagerApplication {

	@Autowired
	private TaskManagerServiceImpl svcTests;
	
	@Test
	public void viewtask() {
		svcTests.getAllTasks();
	}
	
	@Test
	public void addtask() {
		Tasks addVO = new Tasks();	
		addVO.setTaskId(1);
		addVO.setParentTask("Task1");
		addVO.setParentTask("Task2");
		addVO.setPriority(20);
		addVO.setStartDate(new Date(2019, 1, 1));
		addVO.setEndDate(new Date(2019, 2, 2));
		svcTests.addTask(addVO);
	}
	
	@Test
	public void delete() {
		svcTests.deleteTask(8);
	}
	
	@Test
	public void update() {
		Tasks updateVO = new Tasks();	
		updateVO.setTaskId(25);
		updateVO.setPriority(23);
		svcTests.editTask(updateVO);
	}


}
