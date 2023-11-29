package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeMaster;
import com.example.demo.service.SessionService;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionServiceImpl implements SessionService {
	
	
	private static final Map<String, HttpSession> activeSessions = new HashMap<>();


    public EmployeeMaster getUserDataBySessionId(String sessionId) {
        HttpSession session = activeSessions.get(sessionId);
        if (session != null) {
            return (EmployeeMaster) session.getAttribute("userData");
        }
        return null;
    }

    public void addSession(HttpSession session) {
    	System.out.println("Session Id in Service : "+session.getId());
        activeSessions.put(session.getId(), session);
    }

    public void removeSession(HttpSession session) {
        activeSessions.remove(session.getId());
    }

}
