package edu.cssp.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.cssp.beans.CampusResource;
import edu.cssp.dao.CampusResourceDao;
import edu.cssp.utils.HibernateSessionFactory;

public class CampusResourceDaoImpl implements CampusResourceDao {

	@Override
	public Serializable addResource(CampusResource cr) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Serializable idNum = session.save(cr);
		tx.commit();
		session.close();
		return idNum;
	}

	@Override
	public List<CampusResource> getAllResources() {
		List<CampusResource> crList;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			crList = session.createQuery("from CampusResource").list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return crList;
	}

	@Override
	public void updateResource(CampusResource cr) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.update(cr);
		tx.commit();
		session.close();
	}

	@Override
	public int deleteResource(int resourceID) {
		List<CampusResource> crList;
		Session session = null;
		int retCode=-1;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete CampusResource where id=:rid").setInteger("rid", resourceID);
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
	public List<CampusResource> getCampusResourcesByDimensionID(int dimID) {
		Session session = null;
		List<CampusResource> crList = null;
		try{
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			crList = session.createCriteria(CampusResource.class).add(Restrictions.eq("dimension_id", dimID)).list();
//			crList = session.createQuery("from CampusResource where dimension_id=:did").setInteger("did", dimID).list();
			tx.commit();
		}finally{
			if (session != null) {
				session.close();
			}
		}
		return crList;
	}
	
	public static void main(String[] args) {
		List<CampusResource> clist = new CampusResourceDaoImpl().getCampusResourcesByDimensionID(101);
		System.out.println("-------"+clist.size());
	}
}
