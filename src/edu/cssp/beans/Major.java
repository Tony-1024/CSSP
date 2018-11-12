package edu.cssp.beans;

import java.util.HashSet;
import java.util.Set;

public class Major {
	private Integer id;
	private String name;
	private Set<CampusResource> resources = new HashSet<CampusResource>();
	private Set<Clubs> clubs = new HashSet<Clubs>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CampusResource> getResources() {
		return resources;
	}

	public void setResources(Set<CampusResource> resources) {
		this.resources = resources;
	}

	public Set<Clubs> getClubs() {
		return clubs;
	}

	public void setClubs(Set<Clubs> clubs) {
		this.clubs = clubs;
	}
}
