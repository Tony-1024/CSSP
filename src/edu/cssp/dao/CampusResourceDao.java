package edu.cssp.dao;

import java.io.Serializable;
import java.util.List;

import edu.cssp.beans.CampusResource;

public interface CampusResourceDao {
	public Serializable addResource(CampusResource cr);

	public List<CampusResource> getAllResources();
	
	public List<CampusResource> getCampusResourcesByDimensionID(int dimID);

	public void updateResource(CampusResource cr);

	public int deleteResource(int resourceID);
}
