

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Customer;
import controller.Parking;
import controller.Pattern;

@WebServlet("/parking_out")
public class CarOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txt = "Bye Guest";
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
				if(cs.checkValid(car_number) == 0) {
					txt = "Bye User";
				} else {
					txt="Qualification expired.check please";
				}
				
				is_registered = 1;
			}
			Parking.checkOutCar(car_number, is_registered);
			
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/adminPage.jsp");
		RequestDispatcher rd1 = request.getRequestDispatcher("/calculateCharge.jsp.jsp");
		
		rd.forward(request, response);
		rd1.forward(request, response);
	}

}