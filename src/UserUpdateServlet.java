

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Customer;
import controller.Pattern;

@WebServlet("/userupdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, String> userData = new HashMap<String, String>();
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
	    String phone = request.getParameter("phone");
	    String car_number = request.getParameter("car_number");
	    
	    userData.put("name", name);
	    userData.put("phone", phone);
	    userData.put("car_number", car_number);
	    
	    // null 값 처리
	    if(name == null || name.length() == 0) {
	    	PrintWriter script = response.getWriter();
		    	script.println("<script>");
		    	script.println("alert('no blank')");
		    	script.println("history.back()");
		    	script.println("</script>");
		    	script.close();
	    }
	    if(phone == null || phone.length() == 0) {
		   	PrintWriter script = response.getWriter();
			   	script.println("<script>");
		    	script.println("alert('no blank')");
		    	script.println("history.back()");
		    	script.println("</script>");
		    	script.close();
	    }
		if(car_number == null || car_number.length() == 0) {
		   	PrintWriter script = response.getWriter();
			   	script.println("<script>");
		    	script.println("alert('no blank')");
		    	script.println("history.back()");
		    	script.println("</script>");
		    	script.close();
		}
		//정규식 패턴 일치 확인
		if(name.matches(Pattern.namePattern)) {
	    } else {
	    	PrintWriter script = response.getWriter();
		    	script.println("<script>");
		    	script.println("alert('name is incorrect')");
		    	script.println("history.back()");
		    	script.println("</script>");
		    	script.close();
	    }
	    if(phone.matches(Pattern.phonePattern)) {
	    } else {
	    	PrintWriter script = response.getWriter();
		    	script.println("<script>");
		    	script.println("alert('phoneNumber is incorrect')");
		    	script.println("history.back()");
		    	script.println("</script>");
		    	script.close();
	    }
	    if(car_number.matches(Pattern.carNumPattern)) {
	    } else {
	    	PrintWriter script = response.getWriter();
		    	script.println("<script>");
		    	script.println("alert('carNumber is incorrect')");
		    	script.println("history.back()");
		    	script.println("</script>");
		    	script.close();
	    }
	    
	    System.out.println("name: " + name + ", phone: " + phone + 
	            ", car_number: " + car_number + ", end: ");
	    
	    try {
	    	Customer.updateCustomer(userData);
	    	
	    } catch (SQLException | ClassNotFoundException e) {
	    	e.printStackTrace();
	    }

	    String txt = "success";
	    PrintWriter out = response.getWriter();
	    response.setCharacterEncoding("UTF-8");
	    out.print(txt);
	    out.flush();
	    
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rd = request.getRequestDispatcher("/userupdate.jsp");
		rd.forward(request, response);
	}
}
