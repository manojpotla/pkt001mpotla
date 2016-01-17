package com.nirvana.parkingtom.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nirvana.parkingtom.dao.LoginAccountDao;
import com.nirvana.parkingtom.entities.Account;
import com.nirvana.parkingtom.utility.SessionUtil;

@Component("loginAccountDaoImpl")
public class LoginAccountDaoImpl implements LoginAccountDao {
	@Autowired
	SessionUtil sessionUtil;
	private static Logger sl4jLogger = LoggerFactory.getLogger(LoginAccountDaoImpl.class);
	
	private Session session;
	public boolean loginUser(Account account) {
		sl4jLogger.info("In create method");
		session = sessionUtil.getSessionInstance();
		Criteria criteria = session.createCriteria(Account.class);
			criteria.add(Restrictions.eq("userName", account.getUserName()));
			List<Account> accounts = criteria.list();
			session.close();
			if(accounts.isEmpty()){
				return false;
			}
			Account account1 = accounts.get(0);
			if(account1.getPassword().equalsIgnoreCase(account.getPassword())){
				return true;
			}
			return false;
	}

}
