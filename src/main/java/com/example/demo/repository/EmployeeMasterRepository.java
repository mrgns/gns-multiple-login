package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeMaster;

/**
 * @author Pankaj Chauhan
 * @Date 25th July 2022
 * @version 1.0
 */

@Repository
public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster, Integer> {

	@Query("select emp from EmployeeMaster emp " + "where (emp.emailID = :userId or emp.userID = :userId )  "
			+ "and password = SHA1(:password)")
	public Optional<EmployeeMaster> findByUserIdAndPassword(@Param("userId") String userId,
			@Param("password") String password);

	@Query("select emp from EmployeeMaster emp where emp.staffId=?1")
	public EmployeeMaster findByManagerId(Integer id);

	public List<EmployeeMaster> findAll();
	
	@Query(nativeQuery = true, value = "SELECT am.project_alias as name, u.use_case_name AS use_case,\r\n"
			+ "r.read_access, r.write_access,  r.edit_access, r.delete_access, rm.role\r\n"
			+ "FROM rbac_master r, user_role ur , use_cases u , project am  , role_master rm\r\n"
			+ "WHERE ur.role_id=r.role_id AND ur.user_id=?1\r\n"
			+ "AND u.project_id=am.Project_ID  AND r.use_case_id=u.use_case_id \r\n"
			+ "AND rm.role_id = ur.role_id\r\n"
			+ "AND ur.start_Date <= current_timestamp() AND ur.end_date >= current_timestamp()\r\n"
			+ "AND ur.role_id=r.role_id  AND r.deleted_by IS NULL AND u.deleted_by IS NULL\r\n"
			+ "union \r\n"
			+ "SELECT am.project_alias as name, u.use_case_name AS use_case,\r\n"
			+ "r.read_access, r.write_access,  r.edit_access, r.delete_access, rm.role\r\n"
			+ "FROM rbac_master r,  use_cases u , project am  , role_master rm\r\n"
			+ "WHERE rm.role_id =(select role_id  from project_team where Staff_ID=?1 limit 1)\r\n"
			+ "AND u.project_id=am.Project_ID  AND r.use_case_id=u.use_case_id \r\n"
			+ "AND rm.role_id = r.role_id\r\n"
			+ "AND r.deleted_by IS NULL AND u.deleted_by IS NULL")
	public List<Object[]> findRbacklist(Integer staffId);

}
