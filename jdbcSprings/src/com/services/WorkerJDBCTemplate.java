package com.services;

import java.util.List;
import javax.sql.DataSource;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.WorkerDAO;
import com.model.Worker;
import com.Mapper.WorkerMapper;

public class WorkerJDBCTemplate implements WorkerDAO {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}
	
	@Override 
	public void add(Worker worker) throws SQLException {
		String sql = "insert into worker values ("+
				"?,?,?,?,?,?,?"+
				")";
		
		jdbcTemplateObj.update(
				sql,
				worker.getWorkerId(),
				worker.getFirstName(),
				worker.getLastName(),
				worker.getSalary(),
				worker.getJoiningDate(),
				worker.getDept(),
				worker.getEmail()
				);
			
		System.out.println("Worker "+worker.getFirstName()+" added successfully");
	}
	
	@Override
	public void delete(int workerId) throws SQLException {
		String sql = "delete from worker where worker_id=?";
		jdbcTemplateObj.update(sql, workerId);
		System.out.println("Record #"+workerId+" deleted successfully");
	}
	
	public Worker getWorker(int workerId) throws SQLException {
		String sql = "select * from worker where worker_id=?";
		Worker worker = jdbcTemplateObj.queryForObject(
				sql,
				new Object[] {workerId},
				new WorkerMapper()
				);
				
		return worker;
	}

	public List<Worker> getWorkers() throws SQLException {
		String sql = "select * from worker";
		List<Worker> workers = jdbcTemplateObj.query(
				sql,
				new WorkerMapper()
				);
		
		return workers;
	}

	public void update(Worker worker) throws SQLException {
        String sql = "update worker "+
                "set first_name=?,"+
                "last_name=?,"+
                "salary=?,"+
                "joining_date=?,"+
                "department=?,"+
                "mmmail=?"+
                "where worker_id=?";
        
        jdbcTemplateObj.update(
				sql,
				worker.getFirstName(),
				worker.getLastName(),
				worker.getSalary(),
				worker.getJoiningDate(),
				worker.getDept(),
				worker.getEmail(),
				worker.getWorkerId()
				);
        
        System.out.println("Record #"+worker.getWorkerId()+" updated successfully");
	}
}