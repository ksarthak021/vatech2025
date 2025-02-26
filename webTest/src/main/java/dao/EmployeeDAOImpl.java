package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Employee.Gender;
import jakarta.servlet.ServletContext;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	private ServletContext context;
	
	public EmployeeDAOImpl(ServletContext context) {
		
		super();
		this.context = context ;
	}

	

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection((String)context.getAttribute("jdbc_url"),(String)context.getAttribute("jdbc_user"),(String)context.getAttribute("jdbc_password"));
	}

	@Override
	public void save(Employee e) {
		try(Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = "+ rowsAffected);
			
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}

	}

	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setInt(7, (int) e.getId());
	}

	@Override
	public void update(Employee e) {
		try(Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEE SET NAME = ?,AGE = ?,GENDER = ?,SALARY = ?,EXPERIENCE = ?,LEVEL = ? WHERE ID = ?");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = "+ rowsAffected);
			
		} catch (Exception ex) {
			throw new RuntimeException(ex);		
		}
		
	}

	@Override
	public void delete(int id) {
		try (Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			System.out.println("Rows Deleted = " +rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Employee get(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {      // is this next method returns true we have another row, next return false, we are at end the resultset
				Employee e = populateEmployee(rs);
				return e;
			} else {
				new RuntimeException("No employee with ID "+id+" Found. ");
			}
			
			
		} catch (Exception ex) {
			throw new RuntimeException(ex);		
		}
		return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException {
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(Gender.valueOf(rs.getString(4)))
				.salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).build();
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		try (Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
			}catch (Exception ex) {
				throw new RuntimeException(ex);		
			}
		
		return emps;
	}
	
	

	@Override
	public List<Employee> searchByName(String name) {
	    List<Employee> emps = new ArrayList<>();
	    try (Connection conn = getConnection()) {
	        PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE NAME LIKE ?");
	        ps.setString(1, "%" + name + "%");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            emps.add(populateEmployee(rs));
	        }
	    } catch (Exception ex) {
	        throw new RuntimeException(ex);
	    }
	    return emps;
	}

	@Override
	public List<Employee> searchByAge(int age) {
	    List<Employee> emps = new ArrayList<>();
	    try (Connection conn = getConnection()) {
	        PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE AGE = ?");
	        ps.setInt(1, age);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            emps.add(populateEmployee(rs));
	        }
	    } catch (Exception ex) {
	        throw new RuntimeException(ex);
	    }
	    return emps;
	}

	@Override
	public List<Employee> searchBySalary(float salary, String condition) {
	    List<Employee> emps = new ArrayList<>();
	    try (Connection conn = getConnection()) {
	        String query = "SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE SALARY " + condition + " ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setFloat(1, salary);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            emps.add(populateEmployee(rs));
	        }
	    } catch (Exception ex) {
	        throw new RuntimeException(ex);
	    }
	    return emps;
	}

	@Override
	public List<Employee> searchByExperience(int experience) {
	    List<Employee> emps = new ArrayList<>();
	    try (Connection conn = getConnection()) {
	        PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE EXPERIENCE = ?");
	        ps.setInt(1, experience);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            emps.add(populateEmployee(rs));
	        }
	    } catch (Exception ex) {
	        throw new RuntimeException(ex);
	    }
	    return emps;
	}

	@Override
	public List<Employee> searchByLevel(int level) {
	    List<Employee> emps = new ArrayList<>();
	    try (Connection conn = getConnection()) {
	        PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE LEVEL = ?");
	        ps.setInt(1, level);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            emps.add(populateEmployee(rs));
	        }
	    } catch (Exception ex) {
	        throw new RuntimeException(ex);
	    }
	    return emps;
	}
	
	@Override
	public List<Employee> searchByID(int id) {
		List<Employee> emps = new ArrayList<>();
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return emps ;
	}
	
	@Override
	public List<Employee> searchByGender(String gender) {
		List<Employee> emps = new ArrayList<>();
		try(Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE GENDER = ?");
			ps.setString(1, gender);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return emps ;
	}
	
	@Override
	public List<Employee> sortEmployees(String column,String order) {
		List<Employee> emps = new ArrayList<>();
		try(Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE ORDER BY " + column + " " + order);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return emps;
	}

}
