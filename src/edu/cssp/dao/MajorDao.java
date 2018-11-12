package edu.cssp.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import edu.cssp.beans.CampusResource;
import edu.cssp.beans.Clubs;
import edu.cssp.beans.Major;

public interface MajorDao {
	public Serializable addMajor(Major major);

	public List<Major> getAllMajors();
	
	public void updateMajor(Major major);

	public int deleteMajor(int majorID);

	public Set<Clubs> getClubsByMajorID(int majorID);
	
	public Set<CampusResource> getResourcesByMajorID(int majorID);
}
