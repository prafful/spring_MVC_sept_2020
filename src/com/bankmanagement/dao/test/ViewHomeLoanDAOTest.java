package com.bankmanagement.dao.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bankmanagement.dao.ViewHomeLoanDAO;
import com.bankmanagement.entity.HomeLoanDetailsEntity;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewHomeLoanDAOTest {

	@Autowired
	ViewHomeLoanDAO viewHomeLoanDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testRetreiveHomeLoanDetails() {
		List<HomeLoanDetailsEntity> homeLoanList = viewHomeLoanDAO.retreiveHomeLoanDetails("HL-111",1000000000000016L);

		Assert.assertEquals(homeLoanList.get(0).getLoanAccountNumber(), (Long) 1000000000000016L);
	}

}
