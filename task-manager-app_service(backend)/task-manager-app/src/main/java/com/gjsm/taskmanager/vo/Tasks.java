package com.gjsm.taskmanager.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TASKS")
public class Tasks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Task_ID")
	private Long taskID;
	
	@Column(name = "Task_Name")
	private String taskName;
	
	@Column(name = "Start_Date")
	private String startDate;
	
	@Column(name = "End_Date")
	private String endDate;
	
	@Column(name = "Priority")
	private String priority;
	
	@Column(name = "Task_Status")
	private String taskStatus;
	
	@ManyToOne(cascade= {CascadeType.MERGE})
	@JoinColumn(name = "Parent_Task_ID", insertable=true, updatable=true)
	private Tasks parentTask;
	
	
	public Long getTaskID() {
		return taskID;
	}

	public void setTaskID(Long taskID) {
		this.taskID = taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Tasks getParentTask() {
		return parentTask;
	}

	public void setParentTask(Tasks parentTask) {
		this.parentTask = parentTask;
	}

	public Tasks() {
		
	}

	public Tasks (String taskName, String startDate, String endDate, String priority, String taskStatus) {
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.taskStatus = taskStatus;
	}
	
	
}
