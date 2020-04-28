

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Customer;
import controller.Parking;
import controller.Pattern;

@WebServlet("/parking_in")
public class CarInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDateTime inTime = LocalDateTime.now();
		String txt = "Welcome guest";
		Customer cs = new Customer();
		int is_registered = 0;
		
		request.setCharacterEncoding("utf-8");
		String car_number = request.getParameter("car_number");
		
		//차번호 유효성 검사
		if(car_number == null || car_number.length() == 0) {
		  	PrintWriter script = response.getWriter();
		  	script.println("no null");
	    	script.close();
	    }
		if(car_number.matches(Pattern.carNumPattern)) {
	    } else {
	    	PrintWriter script = response.getWriter();
	    	script.println("car_number incorrect");
	    	script.close();
	    }
		
		//등록된 사용자 여부 확인
		try {
			if(cs.checkCustomer(car_number) == 0){
				//등록된 사용자라면 체크!
				txt = "Welcome User";
				is_registered = 1;
			}
			Parking.checkInCar(car_number, inTime, is_registered);
			
		} catch (SQLException | ClassNotFoundException e) {
			txt = "error!";
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
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
		}
		request.setAttribute("ip", ip);
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("/parking_in.jsp");
		rd.forward(request, response);
	}
}