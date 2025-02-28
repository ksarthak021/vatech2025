package servlets;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.Employee;
import dao.Employee.Gender;
import jakarta.servlet.ServletContext;
 
public class DeptDAOImpl implements DeptDAO {
    
    private ServletContext context;
 
    public DeptDAOImpl(ServletContext context) {
        this.context = context;
    }
 
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            (String) context.getAttribute("jdbc_url"),
            (String) context.getAttribute("jdbc_user"),
            (String) context.getAttribute("jdbc_password")
        );
    }
 
    @Override
    public Dept first() {
        try (Connection conn = getConnection()) {
            System.out.println("🔍 Executing SQL: SELECT * FROM dept ORDER BY deptid ASC LIMIT 1");
 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept ORDER BY deptid ASC LIMIT 1");
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                System.out.println("First Department Found: " + rs.getString("deptname"));
                return new Dept(
                    rs.getInt("deptid"),
                    rs.getString("deptname"),
                    rs.getString("deptlocation")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        throw new RuntimeException("No departments found in database!");
    }
 
    @Override
    public Dept last() {
        try (Connection conn = getConnection()) {
            System.out.println("Executing SQL: SELECT * FROM dept ORDER BY deptid DESC LIMIT 1");
 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept ORDER BY deptid DESC LIMIT 1");
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                System.out.println("Last Department Found: " + rs.getString("deptname"));
                return new Dept(
                    rs.getInt("deptid"),
                    rs.getString("deptname"),
                    rs.getString("deptlocation")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        throw new RuntimeException("No departments found in database!");
    }
 
    @Override
    public Dept next(int id) {
        try (Connection conn = getConnection()) {
            System.out.println(" Executing SQL: SELECT * FROM dept WHERE deptid > " + id + " ORDER BY deptid ASC LIMIT 1");
 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept WHERE deptid > ? ORDER BY deptid ASC LIMIT 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                System.out.println("Next Department Found: " + rs.getString("deptname"));
                return new Dept(
                    rs.getInt("deptid"),
                    rs.getString("deptname"),
                    rs.getString("deptlocation")
                );
            } else {
                System.out.println("No next department found! Returning the last department.");
                return last();  // If no next department, return the last department
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        throw new RuntimeException("Error fetching next department!");
    }
 
    @Override
    public Dept previous(int id) {
        try (Connection conn = getConnection()) {
            System.out.println(" Executing SQL: SELECT * FROM dept WHERE deptid < " + id + " ORDER BY deptid DESC LIMIT 1");
 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept WHERE deptid < ? ORDER BY deptid DESC LIMIT 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                System.out.println(" Previous Department Found: " + rs.getString("deptname") + " (ID: " + rs.getInt("deptid") + ")");
                return new Dept(
                    rs.getInt("deptid"),
                    rs.getString("deptname"),
                    rs.getString("deptlocation")
                );
            } else {
                System.out.println(" No previous department found! Returning the first department.");
                return first();  // If no previous department, return the first one
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        throw new RuntimeException("Error fetching previous department!");
    }
 
 
 
    @Override
    public void save(Dept dept) {
        try (Connection conn = getConnection()) {
            System.out.println(" Inserting Department: " + dept.getName());
 
            PreparedStatement ps = conn.prepareStatement("INSERT INTO dept (deptid, deptname, deptlocation) VALUES (?, ?, ?)");
            ps.setInt(1, dept.getId());
            ps.setString(2, dept.getName());
            ps.setString(3, dept.getLocation());
            ps.executeUpdate();
 
            System.out.println(" Department Inserted Successfully!");
        } catch (SQLException e) {
            throw new RuntimeException("Error saving department: " + e.getMessage(), e);
        }
    }
 
    @Override
    public void update(Dept dept) {
        try (Connection conn = getConnection()) {
            System.out.println(" Updating Department: " + dept.getName());
 
            PreparedStatement ps = conn.prepareStatement("UPDATE dept SET deptname = ?, deptlocation = ? WHERE deptid = ?");
            ps.setString(1, dept.getName());
            ps.setString(2, dept.getLocation());
            ps.setInt(3, dept.getId());
            int rowsAffected = ps.executeUpdate();
 
            if (rowsAffected > 0) {
                System.out.println("Department Updated Successfully!");
            } else {
                System.out.println("Department Not Found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating department: " + e.getMessage(), e);
        }
    }
 
    @Override
    public Dept getDept(int id) {
        try (Connection conn = getConnection()) {
            System.out.println(" Fetching Department by ID: " + id);
 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept WHERE deptid = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                System.out.println("Department Found: " + rs.getString("deptname"));
                return new Dept(
                    rs.getInt("deptid"),
                    rs.getString("deptname"),
                    rs.getString("deptlocation")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        throw new RuntimeException("No department found with ID: " + id);
    }
 
    @Override
    public void delete(int id) {
        try (Connection conn = getConnection()) {
            System.out.println(" Deleting Department with ID: " + id);
 
            PreparedStatement ps = conn.prepareStatement("DELETE FROM dept WHERE deptid = ?");
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
 
            if (rowsAffected > 0) {
                System.out.println(" Department Deleted Successfully!");
            } else {
                System.out.println(" Department Not Found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting department: " + e.getMessage(), e);
        }
    }
 
    @Override
    public Set<Dept> getAll() {
        Set<Dept> depts = new HashSet<>();
        try (Connection conn = getConnection()) {
            System.out.println(" Fetching All Departments");
 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept");
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                depts.add(new Dept(
                    rs.getInt("deptid"),
                    rs.getString("deptname"),
                    rs.getString("deptlocation")
                ));
            }
 
            System.out.println("Total Departments Found: " + depts.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return depts;
    }
    
    private Employee populateEmployee(ResultSet rs) throws SQLException {
    	return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(Gender.valueOf(rs.getString(4)))
				.salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).build();
		
	}
    @Override
    public List<Employee> getEmployeesByDeptId(int deptId) {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT e.id, e.name, e.age, e.gender, e.salary, e.experience, e.level, d.deptname, d.deptlocation " +
                "FROM employee e " +
                "JOIN dept d ON e.deptid = d.deptid " +
                "WHERE e.deptid = ?"
            );
            ps.setInt(1, deptId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    Employee.Gender.valueOf(rs.getString("gender")),
                    rs.getFloat("salary"),
                    rs.getInt("experience"),
                    rs.getInt("level"),
                    deptId
                );
                emp.setDeptName(rs.getString("deptname"));
                emp.setDeptLocation(rs.getString("deptlocation"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Error fetching employees for department ID: " + deptId, e);
        }
        return employees;
    }

    
    
}
 
 