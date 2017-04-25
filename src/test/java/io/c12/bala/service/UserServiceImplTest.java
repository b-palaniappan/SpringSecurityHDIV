package io.c12.bala.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.c12.bala.db.dao.UserDao;
import io.c12.bala.db.domain.User;
import io.c12.bala.view.form.RegistrationForm;

public class UserServiceImplTest {
	
	private static final String userId = "jack@c12.io";
	private static final String password = "Password1";

	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserDao userDao;
	
	@BeforeTest
	public void injectDoubles() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAuthenticateUser() {
		// Positive Test Case
		when(userDao.getPasswordHashByUserId(userId)).thenReturn("$s0$41010$dAiki5TNWpASH54dazRjHg==$ogG51PevlOjcRHNkFIlprqMxUuzwJcvX7s8h5h2oMUI=");
		assertTrue(userService.authenticateUser(userId, password));
	}
	
	@Test
	public void testAuthenticateUserNegative() {
		// Negative Test Case
		when(userDao.getPasswordHashByUserId(userId))
			.thenReturn("$s0$41010$YHtdaf1NcTXeP6Uv+SVptA==$ZuDOHKVFsPNodTKec5C6JdSdojfh6NdKzEp/hm0uSHE=");
		assertFalse(userService.authenticateUser(userId, password));
		
		when(userDao.getPasswordHashByUserId(userId)).thenReturn(null);
		assertFalse(userService.authenticateUser(userId, password));
	}
	
	@Test
	public void testAddUser() {
		when(userDao.addUser(any(User.class))).thenReturn(new User());
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setPassword("Password1");
		assertTrue(userService.addUser(registrationForm));
	}
	
	@Test
	public void testAddUserNegative() {
		when(userDao.addUser(any(User.class))).thenThrow(new RuntimeException());
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setPassword("Password1");
		assertFalse(userService.addUser(registrationForm));
	}
}
