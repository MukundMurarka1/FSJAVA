package in.ineuron.coustomizedclass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Coustomizedpage extends HttpServletRequestWrapper{

	public Coustomizedpage(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getParameter(String name) {
		System.out.println("coustomizedpage.getParametre()");
		
		System.out.println("Name is :: " +name);
		String word = super.getParameter(name);
		System.out.println("The entered word is :: "+word);
		
		if(word.equalsIgnoreCase("JAVA") || word.equalsIgnoreCase("JEE") || word.equalsIgnoreCase("reactjs"))
			
			return "SLEEP";
		return word;
		
	}
}
