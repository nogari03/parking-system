

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Admin;


@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("adminID");
		String password = request.getParameter("adminPassword");
		
			int result;
			//스크립트 따로 뺄것
			try {
				result = Admin.checkAdminPassword(id,password);
				
				if (result == 0) {
					PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("location.href = 'admin.jsp'");
						script.println("</script>");
						script.close();
				}
				else if (result == -1) {
					PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('password incorrect')");
						script.println("history.back()");
						script.println("</script>");
						script.close();
				}	
				else if (result == -2) {
					PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('id incorrect')");
						script.println("history.back()");
						script.println("</script>");
						script.close();
				}
				else if (result == -3) {
					PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('database error')");
						script.println("history.back()");
						script.println("</script>");
						script.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
		rd.forward(request, response);
	}

}