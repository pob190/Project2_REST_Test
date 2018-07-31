package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.AdminDaoImpl;
import com.revature.pojos.Admin;
import com.revature.pojos.User;

@Service("AdminService")
public class AdminService {

	AdminDaoImpl ADI = new AdminDaoImpl();
	
	public void addAdmin(Admin a) {
		ADI.putAdmin(a);
	}
	

	
	public Admin validateAdmin(int id, String password) {
		List<Admin> admins = ADI.getAllAdmin();
		for(Admin a : admins) {
			if (id == a.getAdminID() && password.equals(a.getPassword())) {
				return a;
			}
		}
		return null;
	}
	
	
}
