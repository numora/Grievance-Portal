package com.grievance.web.healthcare.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grievance.web.healthcare.newmodel.Address;
import com.grievance.web.healthcare.newmodel.User;

@Component
@Repository("userService")
public class UserServiceImpl extends HibernateDaoSupport implements UserService {

	@Override
	@Transactional
	public boolean createUser(User user) {
		boolean status = false;
		try {
			Address address = user.getAddress();
			getHibernateTemplate().save(address);
			user.setAddress_id(address.getAddress_id());
			getHibernateTemplate().save(user);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}

	@Transactional
	public List<User> findAllUsers() {
		try {
			return getHibernateTemplate().find("from User");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public boolean updateUser(User user) {
		boolean status;
		try {
			getHibernateTemplate().saveOrUpdate(user);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;

	}

	@Transactional
	public boolean deleteUser(User user) {
		boolean status;
		try {
			getHibernateTemplate().delete(user);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}

	@Transactional
	public User checkCredentials(String loginName, String passWord) {
		System.out.print("Check Login Credentials");
		Query query = getSession().getNamedQuery("user.findByLoginName");
		query.setString("name", loginName);
		query.setString("password", passWord);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	@Transactional
	public boolean activateUser(User user) {
		boolean status = false;
		try {
			Query query = getSession().getNamedQuery("user.activateUser");
			query.setLong("activate_id", user.getActivate_id());
			query.setString("email", user.getEmail_id());
			user = (User) query.uniqueResult();
			if (null != user) {
				user.setActivate_id(1);
				getHibernateTemplate().saveOrUpdate(user);
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}

	@Override
	@Transactional
	public boolean updatePassword(User user) {
		boolean status = false;
		try {
			Query query = getSession().getNamedQuery("user.updatePassword");
			String pwd = user.getPassword();
			int activateId = user.getActivate_id();
			query.setString("email", user.getEmail_id());
			user = (User) query.uniqueResult();
			if (null != user) {
				user.setPassword(pwd);
				user.setActivate_id(activateId);
				getHibernateTemplate().saveOrUpdate(user);
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}
}
