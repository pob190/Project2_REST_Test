package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.Admin;
import com.revature.util.ConnectionUtil;

public class AdminDaoImpl implements AdminDao {

	public Admin getAdmin(int id) {
		return (Admin) ConnectionUtil.getSession().get(Admin.class, id);
	}

	public Admin putAdmin(Admin ad) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		sess.save(ad);

		tx.commit();

		return ad;
	}

	public List<Admin> getAllAdmin() {
		return ConnectionUtil.getSession().createQuery("from Admin").list();
	}

	public Admin updateAdmin(Admin ad, int id) {
		Admin oldAd = (Admin) ConnectionUtil.getSession().get(Admin.class, id);
		ad.setAdminID(oldAd.getAdminID());
		ad.setAge(oldAd.getAge());
		ad.setfName(oldAd.getfName());
		ad.setlName(oldAd.getlName());
		ad.setPassword(oldAd.getPassword());
		return ad;
	}

	public void deleteAdmin(Admin ad) {
		ConnectionUtil.getSession().delete(ad);
	}

}
