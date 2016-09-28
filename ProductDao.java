package com.tronicsville.DAO;

import java.util.List;

import com.tronicsville.model.Product;

public interface ProductDao {
public boolean save(Product product);
public boolean update(Product product);
public boolean delete(String id);
public Product get(String id);
public List<Product> list();
}
