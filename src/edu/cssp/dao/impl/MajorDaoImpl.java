package edu.cssp.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.cssp.beans.CampusResource;
import edu.cssp.beans.Clubs;
import edu.cssp.beans.Major;
import edu.cssp.dao.MajorDao;
import edu.cssp.utils.HibernateSessionFactory;

public class MajorDaoImpl implements MajorDao {

	@Override
	public Serializable addMajor(Major major) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Serializable majorID = session.save(major);
		tx.commit();
		return majorID;
	}

	@Override
	public List<Major> getAllMajors() {
		Session session = null;
		List<Major> majorList;
		try {
			session = HibernateSessionFactory.getSession();
			majorList = session.createQuery("from Major").list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return majorList;
	}

	@Override
	public void updateMajor(Major major) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.update(major);
		tx.commit();
	}

	@Override
	public int deleteMajor(int majorID) {
		Session session = null;
		int retCode=-1;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete Major mjr where mjr.id=:mid").setInteger("mid", majorID);
			retCode = query.executeUpdate();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return retCode;
	}
	
	@Override
	public Set<CampusResource> getResourcesByMajorID(int majorID) {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			Major major = session.get(Major.class, new Integer(majorID));
			if(major != null)
				return major.getResources();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}
	

	@Override
	public Set<Clubs> getClubsByMajorID(int majorID) {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			Major major = session.get(Major.class, new Integer(majorID));
			if(major != null)
				return major.getClubs();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public static void main(String[] args) {
/*		CampusResource cr = new CampusResource();
		cr.setName("Gym new");
		cr.setContacts("92401 CA");
		cr.setDimension_id(101);
		cr.setEmail("hello@gmail.com");
		cr.setPhone("8189662469");
		cr.setOthers("Others info");
		Serializable se = new CampusResourceDaoImpl().addResource(cr);*/
		
		Session sess = HibernateSessionFactory.getSession();
		
/*		Clubs club = new Clubs();
		club.setName("Acto Latino");
		club.setContact_name("Bibiana Diaz");
		club.setPhone_no("9493317408");
		club.setDimension_id(1);
		new ClubsDaoImpl().addClub(club);*/
		
		/*		CampusResource cr = sess.get(CampusResource.class, new Integer(22));
		
		Major mjr = new Major();
		mjr.setName("Physic Science2");
		mjr.getResources().add(cr);
		new MajorDaoImpl().addMajor(mjr);*/
		
		
		Major major = sess.get(Major.class, new Integer(28));
/*		Clubs clbs = sess.get(Clubs.class, new Integer(32));
		major.getClubs().add(clbs);
		new MajorDaoImpl().updateMajor(major);;*/
		
		Set<CampusResource> crSet = major.getResources();
		Set<Clubs> clbSet = major.getClubs();

		for(CampusResource cr:crSet){
			System.out.println("ID: "+ cr.getId());
			System.out.println("Name: "+ cr.getName());
		}
		for(Clubs clbs:clbSet){
			System.out.println("ID: "+ clbs.getId());
			System.out.println("Name: "+ clbs.getName());
		}
		
		new MajorDaoImpl().deleteMajor(28);
	}
}
