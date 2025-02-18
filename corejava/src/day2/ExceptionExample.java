package day2;

public class ExceptionExample {

	public static void main(String[] args) {
		Authenticator auth = new Authenticator();
		try {
		//long code = auth.authenticate("scott", "tiger");
		long code = auth.authenticate(null, "tiger");
		System.out.println("Auth Code = "+code);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);         // we want to exception by calling many exceptions
		}
		finally {
			System.out.println("I will always run");
		}

	}

}
