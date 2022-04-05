package com.Mapper;
//package com.workerSpring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.model.Worker;


public class WorkerMapper implements RowMapper<Worker>

{
	public Worker mapRow(ResultSet result, int rowNum) throws SQLException{
		Worker worker = new Worker();
		worker.setWorkerId(result.getInt("worker_id"));
		worker.setFirstName(result.getString("first_name"));
		worker.setLastName(result.getString("last_name"));
		worker.setSalary(result.getInt("salary"));
		worker.setJoiningDate(result.getDate("joining_date"));
		worker.setDept(result.getString("department"));
		worker.setEmail(result.getString("mmmail"));
		
		return worker;
	}
}