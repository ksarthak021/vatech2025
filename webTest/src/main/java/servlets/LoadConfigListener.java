package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		Properties properties = new Properties();
		
		try(InputStream input = LoadConfigListener.class.getClassLoader().getResourceAsStream("db.properties")) {
			
			if(input == null) {
				System.out.println("soory not input found");
				return;
			}
		
		
				properties.load(input);
				
				context.setAttribute("jdbc_url", properties.getProperty("jdbc_url"));
				context.setAttribute("jdbc_user", properties.getProperty("jdbc_user"));
				context.setAttribute("jdbc_password", properties.getProperty("jdbc_password"));
				context.setAttribute("jdbc_driver", properties.getProperty("jdbc_driver"));
				
				System.out.println("Database configuration loadede");
				try {
					Class.forName((String)context.getAttribute("jdbc_driver"));
					System.out.println("JDBC driver loaded");
			
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
		}  catch(IOException e) {
			e.printStackTrace();
		}
	
		EmployeeDAOImpl dao = new EmployeeDAOImpl(context);
		context.setAttribute("emp", dao);
		
	}
}

	
//	@Override
//	public void contextDestroyed(ServletContextEvent sce) {
//		System.out.println("Closing all database connection in the connection pool....");
//	}


