package com.main;

import java.util.List;
import java.sql.Date;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Worker;
import com.services.WorkerJDBCTemplate;

public class MainApp {
	public static void main(String[] args) throws SQLException{
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbcspring.xml");
		
		WorkerJDBCTemplate workerJDBCTemplate = (WorkerJDBCTemplate) context.getBean("workerJDBCTemplate");
		
        Worker worker = new Worker(127900, "krishna", "krishreddy460@gmail.com");

        //workerJDBCTemplate.add(worker);

       // workerJDBCTemplate.delete(120);
        
  //      workerJDBCTemplate.getWorker(1);

        List<Worker> workers = workerJDBCTemplate.getWorkers();
        workers.forEach(System.out::println);

        Worker updateWorker = new Worker(2222, "gopika", "krishna", 50000000,Date.valueOf("2022-03-15"), "CSE", "krisreddy460@gmail.com");
        workerJDBCTemplate.update(updateWorker);
        
	}
}