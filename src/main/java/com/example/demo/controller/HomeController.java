package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.EmployeeMaster;
import com.example.demo.service.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	SessionService sessionService;
	
	@GetMapping("searchPage")
	public String goToSearchPage(HttpServletRequest req) {
		HttpSession session = req.getSession();
		EmployeeMaster emp = (EmployeeMaster) session.getAttribute("userData");
		if(Objects.isNull(emp)) {
			session.invalidate();
			 return "LoginPage";
		}
		return "SearchPage";
	}
	
	@GetMapping("home/{sessionId}")
	public String homePage(@PathVariable("sessionId") String sessionId, HttpServletRequest req) {
		HttpSession session  = req.getSession();
		EmployeeMaster emp = sessionService.getUserDataBySessionId(sessionId);
		//EmployeeMaster emp = (EmployeeMaster) session.getAttribute("userData");
		if(Objects.isNull(emp)) {
			session.invalidate();
			 return "LoginPage";
		}
		return "Home";
	}

}
