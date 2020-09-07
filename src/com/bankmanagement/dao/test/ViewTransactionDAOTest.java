package com.bankmanagement.dao.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bankmanagement.dao.ViewTransactionDAO;
import com.bankmanagement.entity.TransactionDetailsEntity;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewTransactionDAOTest {

	@Autowired
	private ViewTransactionDAO viewTransactionDAO;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRetreiveTransactionDetails() {
		List<TransactionDetailsEntity> transactionDetailsList = viewTransactionDAO.retreiveTransactionDetails(1234567890123456L,
				1000000006L);
		Assert.assertEquals(transactionDetailsList.get(0).getUser().getAccountNumber(), (Long) 1234567890123456L);
	}

}
