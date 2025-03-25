package mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class EmployeeDAOTest {
	
	
	@Test
	void testEmployeeDAOGetAll() {
		EmployeeDAO dao = mock(EmployeeDAO.class);
		List emps = mock(List.class);
		when(emps.size()).thenReturn(2);
		when(emps.get(0)).thenReturn(new Employee(1, "Abc", 11220));
		when(emps.get(1)).thenReturn(new Employee(2, "Def", 33220));
		when(dao.getAll()).thenReturn(emps);
		assertEquals(2, dao.getAll().size());
		assertEquals(1, dao.getAll().get(0).id());
		assertEquals(2, dao.getAll().get(1).id());

	}

	@Test
	void testEmployeeDAO() {
		EmployeeDAO dao = mock(EmployeeDAO.class);
		int id = anyInt();
		System.out.println(id);
		when(dao.get(anyInt())).thenReturn(new Employee(123, "ABC", 10000));
		Employee e = dao.get(10);
		assertEquals(10, e.id());
		id = anyInt();
		e = dao.get(id);
		System.out.println(e.id());
		assertEquals(id, e.id());
		
	}

}
