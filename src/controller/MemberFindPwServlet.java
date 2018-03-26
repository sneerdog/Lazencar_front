package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.Member;
import service.MemberFindService;
import service.MemberFindServiceImpl;

/**
 * Servlet implementation class MemberFindPwServlet
 */
@WebServlet("/login/findPw.do")
public class MemberFindPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberFindService service = new MemberFindServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");

		String memId = request.getParameter("memId");
		String memEmail = request.getParameter("memEmail");
		String memPhone = request.getParameter("memPhone");
		Member mem = new Member();
		mem.setMemId(memId);
		mem.setMemEmail(memEmail);
		mem.setMemPhone(memPhone);
		System.out.println("----입력값 확인 ----");
		System.out.println("아이디 : " + mem.getMemId());
		System.out.println("이메일 : " + mem.getMemEmail());
		System.out.println("핸드폰 : " + mem.getMemPhone());
		Gson gson = new Gson();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("memPw", gson.toJson(service.getMemPw(mem)));
		jsonObject.addProperty("msg", gson.toJson(service.getMsg2(mem)));
		response.getWriter().write(gson.toJson(jsonObject));

	}

}