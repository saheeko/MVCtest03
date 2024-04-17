package kr.bit.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberVO;

@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name="sahee";
		int age=30;
		String email="aaa@gmail.com";
		//forward.jsp
		MemberVO vo=new MemberVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		
		//객체바인딩
		request.setAttribute("vo",vo);
		//forward
		RequestDispatcher rd=request.getRequestDispatcher("view/forward.jsp");
		rd.forward(request, response);
	}

}
