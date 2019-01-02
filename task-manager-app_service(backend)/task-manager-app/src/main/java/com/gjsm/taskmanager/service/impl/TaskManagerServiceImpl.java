package com.gjsm.taskmanager.service.impl;

import java.util.List;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.gjsm.taskmanager.service.TaskManagerService;
import com.gjsm.taskmanager.vo.Tasks;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
		
		public void addTask(Tasks task){
			
			try {
				Integer i = (Integer)jdbcTemplate.queryForObject("select  coalesce(max(parent_id)+1,1) from parent_task", Integer.class);
				String parentSql = "insert into parent_task(parent_id,parent_task) values("+i+",'"+task.getParentTask()+"')";
				jdbcTemplate.execute(parentSql);  
				String sql = "INSERT INTO task(parent_id,task,start_date,end_date,priority,status) "
						+ " VALUES("+i+",'"+task.getTask()+"','"+task.getStartDate()+"','"+task.getEndDate()+"','"+task.getPriority()+"','"+task.getStatus()+"')";
				jdbcTemplate.execute(sql);
			} catch (DataAccessException e) {
					e.printStackTrace();
			}  
		  }

		public List<Tasks> deleteTask(int task_id) {
			 String updateTaskQry = "update task set status='inactive' where task_id =? ";
			 Object[] parems = {task_id};
			 int[] types = {Types.INTEGER};
			 jdbcTemplate.update(updateTaskQry,parems,types);
			 return getAllTasks();
		}

		public void editTask(Tasks task) {
			 String updateTaskQry = "update task set task =?, priority=?, start_date=?, end_date=? where task_id =? ";
			 int[] types = {Types.VARCHAR,Types.INTEGER,Types.DATE,Types.DATE,Types.INTEGER};
			 Object[] parems = {task.getTask(),task.getPriority(),task.getStartDate(),task.getEndDate(),task.getTaskId()};
			 jdbcTemplate.update(updateTaskQry,parems,types);
					 
			 String updateParentQry = "update parent_task set parent_task =? where parent_id =? ";
			 Object[] parentObj = {task.getParentTask(),task.getParentTaskId()};
			 int[] parentObjTypes = {Types.VARCHAR,Types.INTEGER};
			 jdbcTemplate.update(updateParentQry,parentObj,parentObjTypes);
		}

		public List<Tasks> getAllTasks() {
			String query = "select t.task_id,t.task,t.priority,t.start_date,t.end_date, t.status,pt.parent_task,pt.parent_id as parentTaskId from task t left join parent_task pt on t.parent_id=pt.parent_id";
			List<Tasks> taskList = jdbcTemplate.query(query, new BeanPropertyRowMapper(Tasks.class));
			return taskList;
		}
		
		
	}
	
