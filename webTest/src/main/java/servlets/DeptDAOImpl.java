package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	    public void save(Dept dept) {
	        try (Connection conn = getConnection()) {
	            PreparedStatement ps = conn.prepareStatement("INSERT INTO dept (id, name, location) VALUES (?, ?, ?)");
	            ps.setInt(1, dept.getId());
	            ps.setString(2, dept.getName());
	            ps.setString(3, dept.getLocation());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            throw new RuntimeException("Error saving department: " + e.getMessage(), e);
	        }
	    }

	    @Override
	    public Dept first() {
	        try (Connection conn = getConnection()) {
	            System.out.println("Fetching first department...");
	            
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept ORDER BY id ASC LIMIT 1");
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                System.out.println("Department Found: " + rs.getString("name"));
	                return new Dept(rs.getInt("id"), rs.getString("name"), rs.getString("location"));
	            } else {
	                System.out.println("No departments found in database!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Print SQL error
	        }

	        throw new RuntimeException("No departments found in database!");
	    }

	    @Override
	    public Dept last() {
	        try (Connection conn = getConnection()) {
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept ORDER BY id DESC LIMIT 1");
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return new Dept(rs.getInt("id"), rs.getString("name"), rs.getString("location"));
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException("Error fetching last department: " + e.getMessage(), e);
	        }
	        throw new RuntimeException("No departments found in database!");
	    }

	    @Override
	    public Set<Dept> getAll() {
	        Set<Dept> depts = new HashSet<>();
	        try (Connection conn = getConnection()) {
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                depts.add(new Dept(rs.getInt("id"), rs.getString("name"), rs.getString("location")));
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException("Error fetching departments: " + e.getMessage(), e);
	        }
	        return depts;
	    }

		@Override
		public Dept next(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Dept previous(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void update(Dept dept) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Dept getDept(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete(int id) {
			// TODO Auto-generated method stub
			
		}
	

}
