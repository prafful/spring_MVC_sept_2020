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

import com.bankmanagement.bean.EducationLoanBean;
import com.bankmanagement.dao.ApplyEducationLoanDAO;
import com.bankmanagement.entity.EducationLoanDetailsEntity;
import com.bankmanagement.entity.UserDetailsEntity;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplyEducationLoanDAOTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ApplyEducationLoanDAO applyEducationLoanDAO;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	@Transactional
	@Rollback(true)
	public void testInsertEducationLoanDetails() {

		UserDetailsEntity user = new UserDetailsEntity(1234567890111111L, "saving", "x", 99000L);
		EducationLoanBean educationLoanVO = new EducationLoanBean("EL-11111", user, 1000000L, new Date(), 5, 6000000L, 5000000L, "MS", "pritesh", 123456789123l,1234567890111111L );
		Long educationLoanAccountNumber = applyEducationLoanDAO.insertEducationLoanDetails(educationLoanVO);
		System.out.println(educationLoanAccountNumber);

		EducationLoanDetailsEntity educationLoanDetails = (EducationLoanDetailsEntity) sessionFactory.getCurrentSession().get(EducationLoanDetailsEntity.class, educationLoanAccountNumber);
		System.out.println(educationLoanDetails.getEducationLoanAccountNumber());
		Assert.assertEquals(educationLoanAccountNumber, educationLoanDetails.getEducationLoanAccountNumber());

	}

}