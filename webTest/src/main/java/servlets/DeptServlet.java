package servlets;

import java.io.IOException;
import java.util.List;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/depts")
public class DeptServlet extends HttpServlet {
	
	private DeptDAO deptDAO;
	private EmployeeDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    ServletContext context = config.getServletContext();

	    deptDAO = new DeptDAOImpl(context);  
	    dao = (EmployeeDAO) context.getAttribute("employeeDAO");

	    if (dao == null) {
	        throw new IllegalStateException("Error: EmployeeDAO was not initialized properly!");
	    }

	    context.setAttribute("deptDAO", deptDAO);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		HttpSession session = req.getSession();
		Dept current = (Dept) session.getAttribute("current");

		if (current == null) {
			current = deptDAO.first();
		} else {
			if ("First".equals(operation)) {
				current = deptDAO.first();
			} else if ("Last".equals(operation)) {
				current = deptDAO.last();
			} else if ("Previous".equals(operation)) {
		            System.out.println(" Previous button clicked! Current ID: " + current.getId());
		            current = deptDAO.previous(current.getId());
		            System.out.println(" New Current Department after Previous: " + current.getId());
		    } else if ("Next".equals(operation)) {
		            System.out.println(" Next button clicked! Current ID: " + current.getId());
		            current = deptDAO.next(current.getId());
		            System.out.println(" New Current Department after Next: " + current.getId());
			} else {
				current = deptDAO.next(current.getId());
			}
		}
		session.setAttribute("current", current);
		req.setAttribute("dept", current);
		
		// Logging cookie values (Debugging)
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName() + " " + cookie.getValue());
			}
		}
		resp.addCookie(new Cookie("operation", operation));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
	    String operation = req.getParameter("operation");

	    // Fetch Employees
	    List<Employee> emps = dao.getAll();
	    req.setAttribute("emps", emps);

	    // Fetch First Department - Ensure it exists
	    Dept currentDept = null;
	    try {
	        currentDept = deptDAO.first();
	    } catch (Exception e) {
	        System.err.println("Error: No departments found!");
	    }

	    if (currentDept == null) {
	        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No departments found in database.");
	        return;  
	    }

	    req.setAttribute("dept", currentDept);
	    session.setAttribute("current", currentDept);

	    req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}
}
