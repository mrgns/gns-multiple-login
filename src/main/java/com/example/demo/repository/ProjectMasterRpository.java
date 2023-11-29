package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProjectMaster;

@Repository
public interface ProjectMasterRpository extends JpaRepository<ProjectMaster, Integer> {

   

    public List<ProjectMaster> findByClientmasterCustomerID(Integer id);
    
    List<ProjectMaster> findByProjectNameContaining(String keyword);
    
    @Query("Select projectID from ProjectMaster order by projectName")
    List<Integer> getAllProject();
   
    @Query("SELECT pm.projectStatus, pm.startDate, pm.endDate, pm.projectPhase, pm.projectName, pm.projectManager,"
    		+ " cm.companyName FROM ProjectMaster pm JOIN pm.clientmaster cm WHERE pm.projectID = ?1")
    public List<Object[]> getProjectStatusWithStartAndEndDate(Integer projectId);


	public List<ProjectMaster> findByProjectIDInAndDeletedByIsNull(List<Integer> projectIds);

	public List<ProjectMaster> findAllByDeletedByIsNull();
		
}
