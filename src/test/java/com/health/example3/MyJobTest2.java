package com.health.example3;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/com/health/example3/job3.xml"})
public class MyJobTest2 {
	
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static AtomicBoolean isLaunched = new AtomicBoolean(false);
	
	private JobExecution jobExecution;
	
	@Before
	public void setUp() throws Exception {
		if(!isLaunched.getAndSet(true)) {
			jobExecution = jobLauncherTestUtils.launchJob();
			
		}		
	}
	
	@Test
	public void Code() {
		Assert.assertEquals(ExitStatus.COMPLETED.getExitCode(),jobExecution.getExitStatus().getExitCode());
	}
	
	
	@Test
	public void testPersonsCreated() {
		//jdbcTemplate을 사용하여 person테이블의 모든 row룰 가져온다
		List<Person> createdPersons =jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper<Person>(Person.class));
		System.out.println(createdPersons);
		
		//input.scv 라인 갯수 테이블 row갯수가 일치하는지 화인
		Assert.assertEquals(5, createdPersons.size());
	}
}
