package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.RoleMaster;

public interface RoleMasterRepository extends JpaRepository<RoleMaster, Integer> {

	@Query(value = "SELECT rl.role,rl.role_id FROM role_master as rl ,user_role as ur "
			+ " where ur.role_id=rl.role_id and ur.user_id=:staffId", nativeQuery = true)
	public List<RoleMaster> findRoleOfEmployeeById(Integer staffId);

}
