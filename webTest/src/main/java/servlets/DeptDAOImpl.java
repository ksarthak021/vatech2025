package servlets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 

public class DeptDAOImpl implements DeptDAO {
	
	private Map<Integer, Dept> depts ;
	
	public DeptDAOImpl() {
		depts = new HashMap<Integer,Dept>();
	}
	
	@Override
	public void save(Dept dept) {
		depts.put(dept.getId(), dept);
	}
	
	@Override
	public void update(Dept dept) {
		depts.put(dept.getId(), dept);
	}
	
	@Override
	public Dept getDept(int id) {
		return depts.get(id);
	}
	
	@Override
	public void delete(int id) {
		depts.remove(id);
	}
	
	@Override
	public Set<Dept> getAll() {
		Set<Dept> all = new HashSet<Dept>();
		for(int id : depts.keySet()  ) {
			all.add(depts.get(id));
		}
		return all;
	}

	@Override
	public Dept first() {
		return depts.get(depts.keySet().stream().min((a,b) -> (a - b)).get());
		
	}

	@Override
	public Dept last() {
		return depts.get(depts.keySet().stream().max((a,b) -> (a - b)).get());
		
		
	}

	@Override
	public Dept next(int id) {
		if(id ==1) return depts.get(depts.size());
		return depts.get(id+1);
			
	}

	@Override
	public Dept previous(int id) {
		if(id ==1) return getDept(1);
		return depts.get(id-1);
	}
	
	

}
