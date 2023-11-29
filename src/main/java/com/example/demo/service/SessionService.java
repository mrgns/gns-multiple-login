package com.example.demo.service;

import com.example.demo.entity.EmployeeMaster;

import jakarta.servlet.http.HttpSession;

public interface SessionService {

	 public EmployeeMaster getUserDataBySessionId(String sessionId);
	 
	 public void addSession(HttpSession session);
	 
	 public void removeSession(HttpSession session);
}
