package com.example.demo.service;

import com.example.demo.entity.EmployeeMaster;


public interface LoginService {


	EmployeeMaster checkUserCreds(String userId, String pass);

}
