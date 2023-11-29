package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProjectTeam;

@Repository
public interface ProjectTeamRepository extends JpaRepository<ProjectTeam, Integer> {

	Optional<ProjectTeam> findByProjectMasterProjectIDAndEmployeeMasterStaffId(Integer projectId, Integer staffId);

	@Query(nativeQuery = true, value = "SELECT * FROM project_team where project_id=:id1")
	List<ProjectTeam> findProjectALLDeveloperByProjectId(@Param(value = "id1") int id1);
	@Query(nativeQuery = true, value = "SELECT * FROM project_team as pt where pt.project_id=:projectId and pt.staff_id=:staffId")
	ProjectTeam findProjectTeamIdByProjectIdAndStaffId(Integer projectId, Integer staffId);
	@Query(nativeQuery = true, value = "SELECT DISTINCT pt.staff_id,concat(em.F_Name,' ',em.l_Name) fullname,dm.designation,rm.role  \r\n"
			+ "FROM project_team pt \r\n"
			+ "left join employee_master em \r\n"
			+ "on em.Staff_ID=pt.Staff_ID \r\n"
			+ "left join designation_master dm \r\n"
			+ "on dm.designation_id=em.designation_id \r\n"
			+ "left join role_master rm \r\n"
			+ "on rm.role_id=pt.role_id\r\n"
			+ "where pt.Project_ID=:id2 and em.date_of_departure is null  or em.date_of_departure > current_date() \r\n"
			+ "order by fullname;")
	ArrayList<?> getAllProjectTeamDetailsByProjectId(int id2);
	
	@Query(nativeQuery = true, value ="select pt.Project_ID from project_team as pt where pt.role_id=:roleId and pt.Staff_ID=:staffId")
	List<Integer> getProjectByRoleAndStaffId(Integer roleId,Integer staffId);
	@Query(nativeQuery = true, value ="SELECT pt.staff_id,concat(em.F_Name,' ',em.l_Name),rm.role  FROM project_team pt left join employee_master em on em.Staff_ID=pt.Staff_ID left join  role_master rm  on rm.role_id= pt.role_id where pt.Project_ID=:id and rm.role like '%developer%'")
	List<?> getAllProjectDveloperTeamDetailsByProjectId(Integer id);
	
	@Query(nativeQuery = true, value ="SELECT p.Project_Name,c.Company_Name,p.Project_Status,count(bug.project_id) as count,p.Start_Date,\r\n"
			+ "				p.End_Date,bug.project_id FROM tlms_bug as bug\r\n"
			+ "				left join project p on bug.project_id=p.project_id \r\n"
			+ "				left join customer c on c.Customer_ID=p.Customer_ID\r\n"
			+ "				group by bug.project_id order by p.Project_Name")
	List<Object[]> getProjectDataTable();
	
	@Query(nativeQuery=true, value="SELECT  CONCAT(em.F_Name, ' ', em.l_Name) AS name, rm.role, em.Staff_ID\r\n"
			+ "FROM employee_master em\r\n"
			+ "JOIN project_team pt ON em.Staff_ID = pt.Staff_ID\r\n"
			+ "JOIN role_master rm ON rm.role_id = pt.role_id\r\n"
			+ "WHERE pt.Project_ID =:projectId AND (em.date_of_departure IS NULL OR em.date_of_departure > current_date())")
	List<Object[]> findProjectTesterByProjectId(Integer projectId);
	
	@Query(nativeQuery=true, value="SELECT pt.Staff_ID, CONCAT(em.F_Name, ' ', em.L_Name) AS name, rm.role, rm.role_id AS role_id\r\n"
			+ "FROM project_team pt\r\n"
			+ "INNER JOIN role_master rm ON rm.role_id = pt.role_id AND (rm.role LIKE '%Developer%' or rm.role LIKE '%Engineer%')\r\n"
			+ "INNER JOIN employee_master em ON em.Staff_ID = pt.Staff_ID AND (em.date_of_departure IS NULL OR em.date_of_departure > CURRENT_DATE())\r\n"
			+ "WHERE pt.project_id = ?1 and pt.release_date > current_date() ORDER BY name;")
	List<Object[]> getProjectDevelopers(Integer projectId);
	
	@Query(nativeQuery=true, value="SELECT rtm.requirement_id, ts.test_scenario_id, tc.test_case_id,  bug.defect_area, bug.priority, \r\n"
			+ "concat(e.F_Name,\" \",e.L_Name) as dev,concat(t.F_Name,\" \",t.L_Name) as tester,\r\n"
			+ "SUM(CASE WHEN bug.sts_by_tstr_id = 2 THEN 1 ELSE 0 END) AS Closed,\r\n"
			+ "SUM(CASE WHEN bug.sts_by_tstr_id = 1 THEN 1 ELSE 0 END) AS Open,\r\n"
			+ "SUM(CASE WHEN bug.sts_by_tstr_id = 3 THEN 1 ELSE 0 END) AS Reopen,\r\n"
			+ "COUNT(*) AS total\r\n"
			+ "FROM tlms_bug bug\r\n"
			+ "LEFT JOIN tlms_rtm rtm ON rtm.rtm_id = bug.rtm_id\r\n"
			+ "LEFT JOIN tlms_test_scenario ts ON ts.scenario_id = bug.scenario_id\r\n"
			+ "LEFT JOIN tlms_test_case tc ON tc.case_id = bug.case_id\r\n"
			+ "LEFT JOIN employee_master e ON e.Staff_ID = bug.staff_id\r\n"
			+ "LEFT JOIN employee_master t ON t.Staff_ID = bug.created_by\r\n"
			+ "WHERE bug.project_id = ?1\r\n"
			+ "GROUP BY bug.defect_area, rtm.requirement_id, ts.test_scenario_id, tc.test_case_id, e.F_Name, e.L_Name, t.F_Name, t.L_Name\r\n"
			+ "ORDER BY rtm.requirement_id, ts.test_scenario_id, tc.test_case_id;")
	List<Object[]> getAllDetails(Integer projectId);

	@Query(nativeQuery = true, value="SELECT p.Project_ID, p.Project_Name,\r\n"
			+ "SUM(CASE WHEN t.sts_by_tstr_id = 1 THEN 1 ELSE 0 END) AS open,\r\n"
			+ "SUM(CASE WHEN t.sts_by_tstr_id = 2 THEN 1 ELSE 0 END) AS close,\r\n"
			+ "SUM(CASE WHEN t.sts_by_tstr_id = 3 THEN 1 ELSE 0 END) AS reopen,\r\n"
			+ "SUM(CASE WHEN t.sts_by_tstr_id IN (1, 2, 3) THEN 1 ELSE 0 END) AS total,\r\n"
			+ "p.Project_Status FROM tlms_bug AS t\r\n"
			+ "RIGHT JOIN project AS p ON p.Project_ID = t.Project_ID\r\n"
			+ "WHERE p.Project_Status=:status "
			+ "GROUP BY p.Project_ID, p.Project_Name, p.Project_Status\r\n"
			+ "ORDER BY p.Project_Name;")
	List<Object[]> getAllDetailsByStatus(String status); // by Ganesh Shinde
	
	@Query(nativeQuery =true, value="SELECT p.Project_ID, p.Project_Name,\r\n"
			+ "SUM(CASE WHEN t.sts_by_tstr_id = 1 THEN 1 ELSE 0 END) AS open,\r\n"
			+ "SUM(CASE WHEN t.sts_by_tstr_id = 2 THEN 1 ELSE 0 END) AS close,\r\n"
			+ "SUM(CASE WHEN t.sts_by_tstr_id = 3 THEN 1 ELSE 0 END) AS reopen,\r\n"
			+ "SUM(CASE WHEN t.sts_by_tstr_id IN (1, 2, 3) THEN 1 ELSE 0 END) AS total,\r\n"
			+ "p.Project_Status FROM tlms_bug AS t\r\n"
			+ "RIGHT JOIN project AS p ON p.Project_ID = t.Project_ID\r\n"
			+ "WHERE p.Project_ID in ?1 \r\n"
			+ "GROUP BY p.Project_ID, p.Project_Name;")
	List<Object[]> getDataforDeveloper(List<Integer> id); // by Ganesh Shinde
	
	@Query(nativeQuery = true, value="select p.Project_ID,tp.status_id as plan,\r\n"
			+ "br.status_id as br,rtm.status_id as rtm1,ts.status_id as ts1,\r\n"
			+ "tc.status_id as tc1,tsc.status_id tsc1,tr.status_id as tr1 from project p\r\n"
			+ "left join tlms_buss_reqmt br on br.Project_ID=p.Project_ID\r\n"
			+ "left join tlms_rtm rtm on rtm.Project_ID=p.Project_ID\r\n"
			+ "left join tlms_test_scenario ts on ts.Project_ID=p.Project_ID\r\n"
			+ "left join tlms_test_case tc on tc.Project_ID=p.Project_ID\r\n"
			+ "left join tlms_test_script tsc on tsc.Project_ID=p.Project_ID\r\n"
			+ "left join tlms_test_result tr on tr.Project_ID=p.Project_ID\r\n"
			+ "left join tlms_test_plan tp on p.Project_ID=tp.Project_ID\r\n"
			+ "where p.Project_ID=:projectId limit 1;")
	List<Object[]> getProjectAllStatusByProjectId(Integer projectId); // by Ganesh Shinde

	@Query(nativeQuery = true, value="SELECT status_type FROM tlms_status where status_id=:statusId")
	String getStatusById(Integer statusId);
	
	@Query("select pt.projectMaster.projectID from ProjectTeam as pt where pt.employeeMaster.staffId=:staffId")
	List<Integer> getProjectByStaffId(@Param("staffId") Integer staffId);

	@Query(nativeQuery = true, value="SELECT distinct pt.Staff_ID, CONCAT(em.F_Name, ' ', em.L_Name) AS name, rm.role, rm.role_id AS role_id \r\n"
			+ "FROM project_team pt join employee_master em on em.Staff_ID = pt.Staff_ID \r\n"
			+ "join role_master rm on rm.role_id = pt.role_id \r\n"
			+ "join user_role ur on ur.user_id = pt.Staff_ID\r\n"
			+ "where pt.Project_ID =:id2 and ur.end_date > current_date()  order by name;")
	List<Object[]> getProjectStaffDetails(int id2);
}
