package com.nirvana.parkingtom.dao.test;

import java.util.Calendar;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nirvana.parkingtom.dao.UserAccountDao;
import com.nirvana.parkingtom.dao.impl.UserAccountDaoImpl;
import com.nirvana.parkingtom.entities.Account;
import com.nirvana.parkingtom.entities.UserAccount;

@RunWith(MockitoJUnitRunner.class)
public class UserAccountDaoTest {

	Session session;
	UserAccountDao userAccountDao;
	Account account;
	UserAccount userAccount;

	@Before
	public void initalize() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContextTest.xml");
		// DBCommandExecutioner dbCommandExecutioner =
		// (DBCommandExecutioner)applicationContext.getBean("dbCommandExecutioner");
		userAccountDao = (UserAccountDaoImpl) applicationContext
				.getBean("userAccountDaoImpl");
		account = (Account) applicationContext.getBean("accountBean");
		userAccount = (UserAccount) applicationContext.getBean("userAccountBean");
		account.setUserName("mpootla");
		account.setPassword("hello10");
		account.setCreatedDate(Calendar.getInstance().getTime());
		account.setLastUpdatedDate(Calendar.getInstance().getTime());
		account.setQuestion1("what is my name");
		account.setAnswer1("I dont know");
		

		userAccount.setFirstName("Manojj");
		userAccount.setLastName("Botla");
		userAccount.setMobileNumber("4142433210");
		// System.out.println(userPasswordCounter);
	}

	@Test
	public void testAccountInsert() {

		account.setUserAccount(userAccount);
		userAccount.setAccount(account);
		Integer createdId = userAccountDao.registerUser(account, userAccount);
		System.out.println("createdId***********" + createdId);
		// assertThat("The value returned is not null", )

	}

	@Test
	public void findUser(){
		UserAccount userAccount = userAccountDao.findUser("mpootla");
	}
}
