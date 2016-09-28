package com.tronicsville.DAO;
import java.util.List;
import com.tronicsville.model.RegisterModel;
public interface RegisterDao {
	public List<RegisterModel> List();
	public RegisterModel get(String id);
	public void saveorUpdate(RegisterModel registration);
	public void delete(String id);
	public RegisterModel isValidUser(String id, String password);
	}


