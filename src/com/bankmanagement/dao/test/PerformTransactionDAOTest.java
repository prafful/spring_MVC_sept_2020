package com.bankmanagement.dao.test;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bankmanagement.bean.TransactionBean;
import com.bankmanagement.dao.PerformTransactionDAO;
import com.bankmanagement.entity.UserDetailsEntity;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PerformTransactionDAOTest {

	@Autowired
	private PerformTransactionDAO performTransactionDAO;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateTransactionDetails() {
		UserDetailsEntity user = new UserDetailsEntity(1234567890111111L, "saving", "x", 99000L);
		TransactionBean transactionVO = new TransactionBean();
		transactionVO.setUser(user);
		transactionVO.setTransactionType("debit");
		transactionVO.setTransactionAmount(1000L);
		transactionVO.setTransactionDescription("new transaction");
		Double d = performTransactionDAO.updateTransactionDetails(transactionVO);
		System.out.println(d);
		System.out.println(user.getAccountBalance());
		Assert.assertNotEquals(d, user.getAccountBalance());
	}

}
