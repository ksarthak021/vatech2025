package webServices;
 
import java.util.List;
 
import org.apache.cxf.frontend.ServerFactoryBean;
 
public class MovieServer {
 
	public static void main(String[] args) {
		ServerFactoryBean server=new ServerFactoryBean();
		server.setAddress("http://localhost:7777/MovieService");
		
		MovieServiceImpl impl=new MovieServiceImpl();
		impl.addMovie(new Movie(1,"Topgun","English","Action",List.of("Tom Cruise","Jennifer Conley")));
		impl.addMovie(new Movie(2,"De Dhana Dhan","Hindi","Comedy",List.of("Akshay kumar","Sunil Shetty")));
		impl.addMovie(new Movie(3,"3 Idiots","Hindi","Comedy",List.of("Aamir Khan","Kareena Kapoor")));
		impl.addMovie(new Movie(4,"KGF","Hindi","Action",List.of("Yash","Sanjay Datt")));
		impl.addMovie(new Movie(5,"Chal Jivi Laiye","Gujarati","Drama",List.of("Yash Soni","Siddharth Randeria")));
 
		server.setServiceBean(impl);
		server.setServiceClass(MovieService.class);
		server.create();
		System.out.println("Movie Server Running....");
	}
 
}
 
 