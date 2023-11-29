package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeMaster;
import com.example.demo.repository.EmployeeMasterRepository;
import com.example.demo.service.LoginService;

@Service
public class loginServiceImpl implements LoginService {
	
	@Autowired
	EmployeeMasterRepository employeeMasterRepo;

	@Override
	public EmployeeMaster checkUserCreds(String userId, String pass) {
		EmployeeMaster emp = new EmployeeMaster();
		try {
			Optional<EmployeeMaster> op = employeeMasterRepo.findByUserIdAndPassword(userId, pass);
			if(op.isPresent()) {
				emp = op.get();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

}
