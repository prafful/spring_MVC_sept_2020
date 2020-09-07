package com.bankmanagement.dao.test;

import java.util.List;

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

import com.bankmanagement.dao.ViewEducationLoanDAO;
import com.bankmanagement.entity.EducationLoanDetailsEntity;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewEducationLoanDAOTest {

	@Autowired
	private ViewEducationLoanDAO viewEducationLoanDAO;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testRetrieveEducationLoanDetails() {
		List<EducationLoanDetailsEntity> educationLoanList = viewEducationLoanDAO
				.retrieveEducationLoanDetails("EL-123456", null);
		Assert.assertEquals(educationLoanList.get(0).getEducationLoanAccountNumber(), (Long) 1000000000000007L);
	}

}
