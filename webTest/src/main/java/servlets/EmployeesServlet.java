package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.Employee;
import dao.Employee.Gender;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {
	
	private EmployeeDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao= (EmployeeDAO)config.getServletContext().getAttribute("emp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		if("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employee.jsp").forward(req, resp);
			return;
		}
		Employee emp = Employee.builder().id(Integer.parseInt(req.getParameter("id")))
			       .name(req.getParameter("name"))
			       .age(Integer.parseInt(req.getParameter("age")))
			       .gender(Gender.valueOf(req.getParameter("gender").toUpperCase()))
			       .salary(Integer.parseInt(req.getParameter("salary")))
			       .experience(Integer.parseInt(req.getParameter("experience")))
			       .level(Integer.parseInt(req.getParameter("level"))).build();

		if("Save".equals(operation)) {
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employee.jsp").forward(req, resp);
			return;
		}
		if("Update".equals(operation)) {
			dao.update(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employee.jsp").forward(req, resp);
			return;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		if("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Employee e = dao.get(id);
			req.setAttribute("emp", e);
			req.setAttribute("mode", "Update");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employee.jsp").forward(req, resp);
			return;
		}
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		if("getAll".equals(req.getParameter("show"))) {
			List<Employee> emps = new ArrayList<>();  
			emps = dao.getAll();
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employee.jsp").forward(req, resp);
			
			return;
		}
		if("sort".equals(operation)) {
			HttpSession session = req.getSession();
			String column = req.getParameter("column");
			String currentOrder = (String) session.getAttribute("sortOrder");
			String currentColumn = (String) session.getAttribute("sortColumn");
			
			String order = "ASC" ;
			if(column.equals(currentColumn)) {
				order = "DESC".equals(currentOrder) ? "ASC" : "DESC";	
			}
			  session.setAttribute("sortColumn", column);
		      session.setAttribute("sortOrder", order);

		       List<Employee> emps = dao.sortEmployees(column, order);
		       req.setAttribute("emps", emps);
		       req.getRequestDispatcher("employee.jsp").forward(req, resp);
		       return;
		}
		
		if ("search".equals(operation)) {
	        String searchType = req.getParameter("searchType");
	       
	        List<Employee> emps = new ArrayList<>();  
	        switch (searchType) {
	            case "name":
	                String name = req.getParameter("searchValue");
	                emps = dao.searchByName(name);
	                break;
	            case "age":
	                int age = Integer.parseInt(req.getParameter("searchValue"));
	                emps = dao.searchByAge(age);
	                break;
	            case "salary":
	                float salary = Float.parseFloat(req.getParameter("searchValue"));
	                String condition = req.getParameter("condition");
	                emps = dao.searchBySalary(salary, condition);
	                break;
	            case "experience":
	                int experience = Integer.parseInt(req.getParameter("searchValue"));
	                emps = dao.searchByExperience(experience);
	                break;
	            case "level":
	                int level = Integer.parseInt(req.getParameter("searchValue"));
	                emps = dao.searchByLevel(level);
	                break;
	            case "id" :
	            	int id = Integer.parseInt(req.getParameter("searchValue"));
	            	emps = dao.searchByID(id);
	            	break;
	            case "gender" :
	            	String gender = req.getParameter("searchValue");
	            	emps = dao.searchByGender(gender);
	            	break;
	            default:
	                emps = dao.getAll();
	                break;
	        }
	        req.setAttribute("emps", emps);
	        req.getRequestDispatcher("employee.jsp").forward(req, resp);
	        return;
	    }
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employee.jsp").forward(req, resp);
	}

}
