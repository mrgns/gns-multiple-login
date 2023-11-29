package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequirementData {

	@JsonProperty("requirement")
	private String requirement;

	@JsonProperty("requirement_des")
	private String requirementDescription;
}
