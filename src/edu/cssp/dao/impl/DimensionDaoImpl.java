package edu.cssp.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.cssp.beans.Dimension;
import edu.cssp.dao.DimensionDao;
import edu.cssp.utils.HibernateSessionFactory;

public class DimensionDaoImpl implements DimensionDao {
	@Override
	public Serializable addDimension(Dimension dim) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Serializable idNum = session.save(dim);
		tx.commit();
		session.close();
		return idNum;
	}

	@Override
	public List<Dimension> getAllDimensions() {
		List<Dimension> dimList;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			dimList = session.createQuery("from dimension").list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return dimList;
	}

	@Override
	public void updateDimension(Dimension dim) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.update(dim);
		tx.commit();
		session.close();
	}
	
	public static void main(String[] args) {
		DimensionDao dd = new DimensionDaoImpl();
		Dimension dn = new Dimension();
		dn.setName("Emotional");
		dn.setDiscription("about emotional events");
		dd.addDimension(dn);
	}
}
