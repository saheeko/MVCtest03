package kr.bit.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.forward실습
		//int su=100;
		String data="sahee";
		//result.jsp(view페이지)로 data를 전달하여 view page에서 출력하기
		//controller에서 view로 페이지를 전환하는 방법
		//1.redirect
		//2.forward
		/*request.setAttribute("data", data);*/
		response.sendRedirect("view/result.jsp?data="+data);
	}

}
