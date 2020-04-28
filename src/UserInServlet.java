

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Customer;
import controller.Pattern;

@WebServlet("/customer")
public class UserInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, String> userData = new HashMap<String, String>();
		LocalDateTime currentDate = LocalDateTime.now();
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
	    String phone = request.getParameter("phone");
	    String car_number = request.getParameter("car_number");
	    String service_end = request.getParameter("service_end");
	    
	    LocalDateTime serviceDate = currentDate.plusMonths(Integer.parseInt(service_end));
	    
	    // null 일치 확인
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
		if(service_end == null || service_end.length() == 0) {
		  	PrintWriter script = response.getWriter();
			  	script.println("<script>");
		    	script.println("alert('no blank')");
		    	script.println("history.back()");
		    	script.println("</script>");
		    	script.close();
	    }
		
		// 정규식 패턴 일치 확인
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
	    //차번호 정규식 패턴2 추가할것
	    
	    userData.put("name", name);
	    userData.put("phone", phone);
	    userData.put("car_number", car_number);
	    
	    System.out.println("name: " + name + ", phone: " + phone + 
	            ", car_number: " + car_number + ", end: " + service_end);
	    
	    try {
	    	if(Customer.registerCustomer(userData, serviceDate) == 0){
	    	}
	    	else {
	    		PrintWriter script = response.getWriter();
			    	script.println("<script>");
			    	script.println("alert('already exist car_number')");
			    	script.println("history.back()");
			    	script.println("</script>");
			    	script.close();
	    	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    } catch (ClassNotFoundException e) {
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

		String ip = request.getRemoteAddr();
		if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String ipAddress = inetAddress.getHostAddress();
			ip = ipAddress;
			System.out.println(ip);
		}
		request.setAttribute("ip", ip);
		request.getRequestDispatcher("customer.jsp").forward(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("/customer.jsp");
		rd.forward(request, response);
	}
}
