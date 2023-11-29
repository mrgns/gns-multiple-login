package com.example.demo.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientProject {
	private List<ClientMaster>cList;
	private List<ProjectMaster>pList;
	
}
