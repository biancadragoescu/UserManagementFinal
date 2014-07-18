package com.evozon.usermanagement.testing;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.evozon.usermanagement.model.User;

public class UserTest {
	
	User user;

	@Test
	public void test() {
		testSetAndGetUserName();
	}
	
	@Before
	public void setUp() {
		user = new User("mrazvan", "mrazvan@yahoo.com", Calendar.getInstance().getTime(), "0725012076", "Razvan", "Moldovan", "raz", true);
	}
	
	private void testSetAndGetUserName() {
		Assert.assertEquals("mrazvan", user.getUserName());
	}

}
