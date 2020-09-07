package com.bankmanagement.dao.test;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bankmanagement.bean.HomeLoanBean;
import com.bankmanagement.dao.ApplyHomeLoanDAO;
import com.bankmanagement.entity.HomeLoanDetailsEntity;
import com.bankmanagement.entity.UserDetailsEntity;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplyHomeLoanDAOTest {

	@Autowired
	private ApplyHomeLoanDAO applyHomeLoanDAO;
	@Autowired
	private SessionFactory sessionFactory;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testInsertHomeLoanDetails() {
		UserDetailsEntity user = new UserDetailsEntity(1234567890111111L, "saving", "x", 99000L);
		HomeLoanBean homeLoanVO = new HomeLoanBean("HL-111", user, 10000L, new Date(), 3, 300000L, "cognizant", "pat",
				3, 1, 1234567890111111L );
		Long homeLoanAccountNumber = applyHomeLoanDAO.insertHomeLoanDetails(homeLoanVO);
		System.out.println(homeLoanAccountNumber);
		HomeLoanDetailsEntity homeLoanDetails = (HomeLoanDetailsEntity) sessionFactory.getCurrentSession().get(HomeLoanDetailsEntity.class, homeLoanAccountNumber);
		System.out.println(homeLoanDetails.getLoanAccountNumber());
		Assert.assertEquals(homeLoanAccountNumber, homeLoanDetails.getLoanAccountNumber());

	}

}
