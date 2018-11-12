package edu.cssp.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jboss.jandex.Main;

import edu.cssp.beans.Clubs;
import edu.cssp.dao.ClubsDao;
import edu.cssp.utils.HibernateSessionFactory;

public class ClubsDaoImpl implements ClubsDao {

	@Override
	public Serializable addClub(Clubs clb) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Serializable idNum = session.save(clb);
		tx.commit();
		session.close();
		return idNum;
	}

	@Override
	public List<Clubs> getAllClubs() {
		List<Clubs> crList;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			crList = session.createQuery("from Clubs").list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return crList;
	}

	@Override
	public void updateClubs(Clubs cr) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.update(cr);
		tx.commit();
		session.close();
	}

	@Override
	public int deleteClub(int clubID) {
		Session session = null;
		int retCode=-1;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete Clubs where id=:rid").setInteger("rid", clubID);
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
	public List<Clubs> getClubsByDimensionID(int dimID) {
		Session session = null;
		List<Clubs> cList = null;
		try{
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			cList = session.createCriteria(Clubs.class).add(Restrictions.eq("dimension_id", dimID)).list();
//			cList = session.createQuery("from Clubs where dimension_id=:did").setInteger("did", dimID).list();
			tx.commit();
		}finally{
			if (session != null) {
				session.close();
			}
		}
		return cList;
	}
	
	public static void main(String[] args) {
		List<Clubs> clist = new ClubsDaoImpl().getClubsByDimensionID(1);
		System.out.println("-------"+clist.size());
	}
}
