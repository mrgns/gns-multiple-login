package com.example.demo.controller;

import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.EmployeeMaster;
import com.example.demo.service.LoginService;
import com.example.demo.service.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	SessionService sessionService;

	public String createSessionId() {
		return UUID.randomUUID().toString();
	}

	@GetMapping("/")
	public String getLoginWithId(Model model) {
		return "LoginPage";
	}

	@SuppressWarnings("null")
	@PostMapping("/login")
	public String login(@RequestParam("userId") String userId, @RequestParam("pass") String pass, HttpServletRequest req) {
		System.out.println("UserId: " + userId + "\nPass: " + pass);

		try {
			HttpSession session = req.getSession();
				EmployeeMaster emp = loginService.checkUserCreds(userId, pass);
				if (emp != null) {
					session.setAttribute("userData", emp);
					sessionService.addSession(session);
					System.out.println("In controller : "+session.getId());
					return "redirect:/"+"home/"+session.getId();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "LoginPage";
	}

	@GetMapping("logout")
	public String logOut(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "LoginPage";
	}

	
}
