package edu.cssp.dao;

import java.io.Serializable;
import java.util.List;

import edu.cssp.beans.UserProfile;

public interface UserProfileDao {
	public Serializable addUserProfile(UserProfile user);

	public List<UserProfile> getAllUsers();

	public int removeUserProfile(int userID);
}
