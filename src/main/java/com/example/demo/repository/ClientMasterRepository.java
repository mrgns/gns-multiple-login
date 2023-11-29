package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ClientMaster;

public interface ClientMasterRepository extends JpaRepository<ClientMaster, Integer> {
}
