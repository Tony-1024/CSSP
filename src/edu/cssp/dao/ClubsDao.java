package edu.cssp.dao;

import java.io.Serializable;
import java.util.List;

import edu.cssp.beans.Clubs;

public interface ClubsDao {
	public Serializable addClub(Clubs clb);

	public List<Clubs> getAllClubs();
	
	public List<Clubs> getClubsByDimensionID(int dimID);
	
	public void updateClubs(Clubs cr);

	public int deleteClub(int clubID);
}
