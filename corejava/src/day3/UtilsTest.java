package day3;                                          // TEST FOR HASH SET AND TREE SET

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class UtilsTest {

	public class Point implements Comparable<Point> {                       // this sub class can be referenced by anybody if the class is public   and in case of protected any its sub inner class can use it
		
		private int x;
		private int y;
		
		public Point() {}
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
			public int compareTo(Point other) {                      // return type will integer
				if(this == other || this.equals(other))
					return 0;
				int diffX = x - other.x;
				if(diffX == 0) return y - other.y;
				return diffX;
			}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(x, y);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return x == other.x && y == other.y;
		}

		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}

		private UtilsTest getEnclosingInstance() {
			return UtilsTest.this;
		}
	}
    
	public void testMaps() {
		tryingMaps(new HashMap<String, Integer>());
		tryingMaps(new TreeMap<String, Integer>());
	}
	
	public void tryingMaps(Map<String,Integer>numbers) {                // in maps we have to always use integer and not int 
		assertEquals(0,numbers.size());
		numbers.put("One",1);
		assertEquals(1,numbers.size());
		assertEquals(1,numbers.get("One"));
		
        numbers.put("One",2);	
		assertEquals(1,numbers.size());                         // here value is 1
		assertEquals(2,numbers.get("One"));                    // here value is 2
		
		numbers.put("one",1);	                            // here the size changes becoz capital O becomes the smaller o
		assertEquals(2,numbers.size());
		assertEquals(1,numbers.get("one"));
	}
	
	@Test
	public void testArrayList() {
		tryingLists(new ArrayList<UtilsTest.Point>());
		tryingLists(new LinkedList<UtilsTest.Point>());
	}
	
	public void tryingLists(List<Point>points) {
	     assertEquals(0,points.size());
	     Point p = new Point(2,3);
	     points.add(p);
	     assertEquals(1,points.size());
	     
	     points.add(p);
	     assertEquals(2,points.size());
	     
	     points.add(new Point(2,3));                      
	     assertEquals(3,points.size());            // yaha par size 1 hi rahega becoz contents is same (2,3)
	     
	     points.add(new Point(3,2));
	     assertEquals(4,points.size());             // yaha par change hoga to 2 becoz yaha contents are different (3,2)
	}
	
	
	public void tryingSets(Set<Point>points) {
	     assertEquals(0,points.size());
	     Point p = new Point(2,3);
	     points.add(p);
	     assertEquals(1,points.size());
	     
	     points.add(p);
	     assertEquals(1,points.size());
	     
	     points.add(new Point(2,3));                      
	     assertEquals(1,points.size());            // yaha par size 1 hi rahega becoz contents is same (2,3)
	     
	     points.add(new Point(3,2));
	     assertEquals(2,points.size());             // yaha par change hoga to 2 becoz yaha contents are different (3,2)
	}
	
	@Test
	public void testHashSet() {

		tryingSets(new HashSet<UtilsTest.Point>());
		
	}
	
	@Test
	public void testTreeSet() {

		tryingSets(new TreeSet<UtilsTest.Point>());
		
	}
}
