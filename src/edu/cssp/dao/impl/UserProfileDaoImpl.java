package edu.cssp.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.cssp.beans.UserProfile;
import edu.cssp.dao.UserProfileDao;
import edu.cssp.utils.HibernateSessionFactory;

public class UserProfileDaoImpl implements UserProfileDao {

	@Override
	public Serializable addUserProfile(UserProfile user) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Serializable idNum = session.save(user);
		tx.commit();
		session.close();
		return idNum;
	}

	@Override
	public List<UserProfile> getAllUsers() {
		Session session = HibernateSessionFactory.getSession();
//		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UserProfile");
		List<UserProfile> uList = query.list();
//		tx.commit();
		session.close();
		return uList;
	}

	@Override
	public int removeUserProfile(int userID) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete UserProfile as UP where UP.id=:uid").setInteger("uid", userID);
		query.executeUpdate();
		tx.commit();
		session.close();
		return 0;
	}

	public static void main(String args[])
	{
		UserProfile user = new UserProfile();
		user.setMajor_id(1001);
		user.setName("Liu");
		user.setYear(new Date());
		new UserProfileDaoImpl().addUserProfile(user);
		List<UserProfile> uList = new UserProfileDaoImpl().getAllUsers();
		System.out.println("========== "+uList.size());
//		 new UserProfileDaoImpl().removeUserProfile(4);
	}
}