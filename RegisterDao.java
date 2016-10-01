package com.tronicsville.DAO;
import java.util.List;
import com.tronicsville.model.RegisterModel;
public interface RegisterDao {
	public List<RegisterModel> List();
	public RegisterModel get(String id);
	public boolean update(RegisterModel register);
	public boolean delete(String id);
	public RegisterModel isValidUser(String id, String password);
	public boolean save(RegisterModel register);
	}


