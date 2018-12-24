package com.gjsm.taskmanager.jparepo;


import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gjsm.taskmanager.vo.Tasks;

@Repository
public interface TaskManagerJpaRepo extends JpaRepository<Tasks, Long> {
	
	Optional<Tasks> findById(Long taskID);

}
