package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;


@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트로부터 넘어온 파라메터 중에 한글데이터가 있을경우 한글이 꺠지지않게 하기위한것.
		request.setCharacterEncoding("utf-8");
		//파라메터 수집(vo)
		int num=Integer.parseInt(request.getParameter("num"));
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		MemberVO vo=new MemberVO();
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao=new MemberDAO();
		int cnt=dao.memberUpdate(vo);
		 if(cnt>0) {
			 //가입성공
			 //out.println("insert success"); 다시 리스트페이지로가기위해 /MVC01/memberList.do
			 response.sendRedirect("/MVC01/memberList.do"); //가입성공하면  RESPONSE응답을  하고 보낸다다시 (sendRedirect)
		 }else {
			 //가입실패 - 예외 객체를 생성 후 WAS=TOMCAT에 던짐
			 throw new ServletException("not insert");
		 }
	}

}
