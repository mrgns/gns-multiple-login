package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeProfile;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Integer> {

	 @Query("SELECT e FROM EmployeeProfile e WHERE e.staffId =:staffId")
	 EmployeeProfile getEmployeeProfile(Integer staffId);

}
