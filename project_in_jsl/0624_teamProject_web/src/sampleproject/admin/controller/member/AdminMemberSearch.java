package sampleproject.admin.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sampleproject.member.dao.MemberDAO;
import sampleproject.member.vo.MemberVO;

@WebServlet("/adminmembersearch.do")
public class AdminMemberSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminMemberSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String option=request.getParameter("search");
		String input=request.getParameter("search_name");
		MemberDAO dao= MemberDAO.getInstance();
		List<MemberVO> list =dao.memberSearch(option, input);
		request.setAttribute("list",list);
		request.setAttribute("count",list.size());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin/member_list.jsp");
		dispatcher.forward(request, response);
	}

}
