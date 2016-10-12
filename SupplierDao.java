package com.tronicsville.DAO;

import java.util.List;

import com.tronicsville.model.Product;
import com.tronicsville.model.Supplier;

public interface SupplierDao {
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(String id);
	public Supplier get(String id);
	public List<Supplier> list();
	public Supplier getByName(String name);
}
