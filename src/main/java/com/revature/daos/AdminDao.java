package com.revature.daos;

import java.util.List;

import com.revature.pojos.Admin;

public interface AdminDao {

	public Admin getAdmin(int id);
	public List<Admin> getAllAdmin();
	public Admin putAdmin(Admin ad);
	public Admin updateAdmin(Admin ad, int id);
	public void deleteAdmin(Admin ad);
}
