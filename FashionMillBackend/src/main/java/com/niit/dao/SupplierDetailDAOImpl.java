package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.SupplierDetail;

@Repository("supplierDAO")
@Transactional
public class SupplierDetailDAOImpl implements SupplierDetailDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	//@Override
	public boolean addSupplier(SupplierDetail supplierDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(supplierDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	//@Override
	public boolean deleteSupplier(SupplierDetail supplierDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(supplierDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	//@Override
	public boolean updateSupplier(SupplierDetail supplierDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(supplierDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	//@Override
	public List<SupplierDetail> listSuppliers() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from SupplierDetail");
		List<SupplierDetail> listSuppliers=query.list();
		session.close();
		return listSuppliers;
	}

	//@Override
	public SupplierDetail getSupplier(int supplierID) 
	{
		Session session=sessionFactory.openSession();
		SupplierDetail supplierDetail=session.get(SupplierDetail.class,supplierID);
		session.close();
		return supplierDetail;
	}
	
}
