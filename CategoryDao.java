package com.tronicsville.DAO;
import java.util.List;
import com.tronicsville.model.Category;
public interface CategoryDao { 
	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(String id);
	public Category get(String id);
	public List<Category> list();

}