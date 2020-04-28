

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

@WebServlet("/user_delete")
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("user_name");
		String txt = "delete complete";
		try {
			Customer.deleteCustomer(name);
		} catch (SQLException | ClassNotFoundException e) {
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/userdelete.jsp");
		rd.forward(request, response);
	}

}