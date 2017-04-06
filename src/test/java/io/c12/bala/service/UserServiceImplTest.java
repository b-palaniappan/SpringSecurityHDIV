package io.c12.bala.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.c12.bala.db.dao.UserDao;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	private static final String userId = "jack@c12.io";
	private static final String password = "Password1";

	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserDao userDao;

	@Test
	public void authenticateUser() {
		// Positive Test Case
		when(userDao.getPasswordHashByUserId(userId)).thenReturn("$s0$41010$dAiki5TNWpASH54dazRjHg==$ogG51PevlOjcRHNkFIlprqMxUuzwJcvX7s8h5h2oMUI=");
		assertTrue(userService.authenticateUser(userId, password));
		
		// Negative Test Case
		when(userDao.getPasswordHashByUserId(userId)).thenReturn("$s0$41010$YHtdaf1NcTXeP6Uv+SVptA==$ZuDOHKVFsPNodTKec5C6JdSdojfh6NdKzEp/hm0uSHE=");
		assertFalse(userService.authenticateUser(userId, password));
	}
}
