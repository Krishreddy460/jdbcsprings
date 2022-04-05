package com.dao;



import java.sql.*;
import java.util.List;
import javax.sql.DataSource;

import com.model.Worker;

public interface WorkerDAO {
	
	public void setDataSource(DataSource dataSource);
	
	public void add(Worker worker) throws SQLException;

	public void delete(int workerId) throws SQLException;

	public Worker getWorker(int workerId) throws SQLException;

	public List<Worker> getWorkers() throws SQLException;

	public void update(Worker worker) throws SQLException;
}