package com.ssafy.homework.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.homework.model.dto.Book;
import com.ssafy.homework.model.dto.User;
import com.ssafy.homework.model.service.BookService;
import com.ssafy.homework.model.service.UserService;

@Controller
public class MainController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/", "main"})
	public String main() {
		return "index";
	}
	@PostMapping("login")
	public String login(User user , Model model, HttpSession session, HttpServletResponse response) throws SQLException {
		User u = userService.login(user);
		System.out.println("로그인");
		if(u == null) model.addAttribute("msg", "로그인 실패");
		else session.setAttribute("userinfo", u);
		return "index";
	}
	@GetMapping("logout")
	public String logout(Model model, HttpSession session) throws SQLException {
		System.out.println("로그아웃");
		session.invalidate();
		return "index";
	}
	@GetMapping("list")
	public void list(Model model) throws SQLException {
		System.out.println("리스트");
		model.addAttribute("books", bookService.select());
	}
	@GetMapping("registform")
	public String registform() throws SQLException {
		System.out.println("등록페이지");
		return "regist";
	}
	@GetMapping("register")
	public String regist(Model model, Book book) throws SQLException {
		System.out.println("등록");
		int result = bookService.insert(book);
		if(result == 1) {
			model.addAttribute("book", book);
			return "regist_result";
		}else {
			model.addAttribute("msg", "은 이미 등록되어있습니다.");
			return "regist";
		}
	}
	@GetMapping("deletelist")
	public String deleteAll() throws SQLException {
		System.out.println("전체 삭제");
		bookService.deleteAll();
		return "redirect:list";
	}
	@GetMapping("delete")
	public String delete(String isbn) throws SQLException {
		System.out.println("삭제");
		bookService.delete(isbn);
		return "redirect:list";
	}
	@GetMapping("detail")
	public void detail(String isbn, Model model) throws SQLException {
		model.addAttribute("book", bookService.getDetail(isbn));
	}
	@GetMapping("modifyform")
	public String modifyform(String isbn, Model model) throws SQLException {
		model.addAttribute("book", bookService.getDetail(isbn));
		return "modify";
	}
	@GetMapping("modify")
	public String modify(Book book) throws SQLException {
		System.out.println("수정");
		bookService.update(book);
		return "redirect:list";
	}
}
