/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RBACMaster;

/**
 * @author Rupesh Gawas
 * @Date 20-07-2023
 * @Version 1.0
 */

public interface RBACMasterRepository extends JpaRepository<RBACMaster, Integer> {

}
