package com.niit.dao;

import java.util.List;

import com.niit.model.SupplierDetail;

public interface SupplierDetailDAO 
{
	public boolean addSupplier(SupplierDetail supplierDetail);
	public boolean deleteSupplier(SupplierDetail supplierDetail);
	public boolean updateSupplier(SupplierDetail supplierDetail);
	public List<SupplierDetail> listSuppliers();
	public SupplierDetail getSupplier(int supplierID);
}
