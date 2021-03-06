package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.GuestBookDto;
import com.ssafy.model.MemberDto;
import com.ssafy.model.service.GuestBookService;
import com.ssafy.model.service.GuestBookServiceImpl;
import com.ssafy.model.service.LoginService;
import com.ssafy.model.service.LoginServiceImpl;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImpl;

@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService;
	private GuestBookService guestBookService;
	private MemberService memberService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginServiceImpl();
		guestBookService = new GuestBookServiceImpl();
		memberService = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		
		if("mvlogin".equals(act)) {
			response.sendRedirect(root + "/user/login.jsp");
		} else if("mvjoin".equals(act)) {
			response.sendRedirect(root + "/user/join.jsp");
		} else if("join".equals(act)) {
			join(request, response);
		} else if("login".equals(act)) {
			login(request, response);
		} else if("logout".equals(act)) {
			logout(request, response);
		} else if("mvwrite".equals(act)) {
			response.sendRedirect(root + "/guestbook/write.jsp");
		} else if("write".equals(act)) {
			writeArticle(request, response);
		} else if("list".equals(act)) {
			listArticle(request, response);
		} else if("mvmodify".equals(act)) {
			moveModifyArticle(request, response);
		} else if("modify".equals(act)) {
			modifyArticle(request, response);
		} else if("delete".equals(act)) {
			deleteArticle(request, response);
		} else {
			response.sendRedirect(root);
		}
	}

	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ???????????? ????????? ???????????? ???????????? ?????? ????????? ??? ????????? ??????
		MemberDto paramDto = new MemberDto();
		String zipcode = "(" + request.getParameter("zipcode") + ")";
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("address_detail");
		paramDto.setAddress(zipcode + address + " " + addressDetail);
		paramDto.setEmail(
				request.getParameter("emailid")
				+ "@"
				+ request.getParameter("emaildomain")
		);
		paramDto.setUserpwd(request.getParameter("userpwd"));
		paramDto.setUserid(request.getParameter("userid"));
		paramDto.setUsername(request.getParameter("username"));
		
		String path = "/index.jsp";
		try {
			memberService.join(paramDto);
			response.sendRedirect(request.getContextPath() + path);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "???????????? ?????? ??? ????????? ??????????????????.");
			path = "/error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	private void deleteArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		int articleno = Integer.parseInt(request.getParameter("articleno"));
		
		try {
			guestBookService.deleteArticle(articleno);
			path = "/main.do?act=list&key=&word=";
			response.sendRedirect(request.getContextPath() + path);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "????????? ?????? ??? ????????? ??????????????????.");
			path = "/error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	private void modifyArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		GuestBookDto guestBookDto = new GuestBookDto();
		guestBookDto.setArticleno(Integer.parseInt(request.getParameter("articleno")));
		guestBookDto.setSubject(request.getParameter("subject"));
		guestBookDto.setContent(request.getParameter("content"));
		
		try {
			guestBookService.modifyArticle(guestBookDto);
			path = "/main.do?act=list&key=&word=";
			response.sendRedirect(request.getContextPath() + path);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "???????????? ????????? ??????????????????.");
			path = "/error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	private void moveModifyArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		int articleno = Integer.parseInt(request.getParameter("articleno"));
		
		try {
			GuestBookDto guestBookDto = guestBookService.getArticle(articleno);
			request.setAttribute("article", guestBookDto);
			path = "/guestbook/modify.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "????????? ?????? ??? ????????? ??????????????????.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void listArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		try {
			List<GuestBookDto> list = guestBookService.listArticle(key, word);
			request.setAttribute("articles", list);
			path = "/guestbook/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "???????????? ???????????? ??? ????????? ??????????????????.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void writeArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if(memberDto != null) {
			GuestBookDto guestBookDto = new GuestBookDto();
			guestBookDto.setUserid(memberDto.getUserid());
			guestBookDto.setSubject(request.getParameter("subject"));
			guestBookDto.setContent(request.getParameter("content"));
			
			try {
				guestBookService.writeArticle(guestBookDto);
				path = "/guestbook/writesuccess.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "???????????? ????????? ??????????????????.");
				path = "/error/error.jsp";
			}
		} else {
			request.setAttribute("msg", "????????? ??? ?????? ????????? ??????????????????.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userinfo");
//		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
//		MemberDto paramDto = new MemberDto();
//		paramDto.setUserid(userid);
//		paramDto.setUserpwd(userpwd);
		
		try {
			MemberDto memberDto = loginService.login(userid, userpwd);
			//MemberDto memberDto = loginService.login(paramDto);
			if(memberDto != null) {
//				session ??????
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", memberDto);
				
//				cookie ??????
				String idsave = request.getParameter("idsave");
				if("saveok".equals(idsave)) {//????????? ????????? ?????? ?????????.
					Cookie cookie = new Cookie("ssafy_id", userid);
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);//40?????? ??????.
					response.addCookie(cookie);
				} else {//????????? ????????? ?????? ?????????.
					Cookie cookies[] = request.getCookies();
					if(cookies != null) {
						for(Cookie cookie : cookies) {
							if("ssafy_id".equals(cookie.getName())) {
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
			} else {
				request.setAttribute("msg", "????????? ?????? ???????????? ?????? ??? ???????????? ?????????.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "????????? ??? ????????? ??????????????????.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
}
