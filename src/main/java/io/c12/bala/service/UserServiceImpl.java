/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.c12.bala.service;

import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lambdaworks.crypto.SCryptUtil;

import io.c12.bala.db.dao.UserDao;
import io.c12.bala.db.domain.Address;
import io.c12.bala.db.domain.AddressType;
import io.c12.bala.db.domain.Auth;
import io.c12.bala.db.domain.PhoneNumber;
import io.c12.bala.db.domain.PhoneType;
import io.c12.bala.db.domain.Status;
import io.c12.bala.db.domain.User;
import io.c12.bala.view.form.RegistrationForm;

/**
 * @author b.palaniappan
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource(name = "userDao")
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see io.c12.bala.service.UserService#authenticateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticateUser(String userId, String password) {
		logger.info("Authenticate user : " + userId);
		String passwordHash = userDao.getPasswordHashByUserId(userId);
		if (passwordHash == null) {
			return false;
		}
		return SCryptUtil.check(password, passwordHash);
	}

	@Override
	public boolean addUser(RegistrationForm registerForm) {
		User user = new User();
		user.setKey(UUID.randomUUID().toString());
		user.setFirstName(registerForm.getFirstName());
		if (!StringUtils.isEmpty(registerForm.getMiddleInitial())) {
			user.setMiddleInitial(registerForm.getMiddleInitial());
		}
		user.setLastName(registerForm.getLastName());
		if (!StringUtils.isEmpty(registerForm.getSuffix())){
			user.setSuffix(registerForm.getSuffix());
		}
		
		Auth auth = new Auth();
		auth.setUserId(registerForm.getEmail());
		auth.setPassword(SCryptUtil.scrypt(registerForm.getPassword(), 16, 16, 16));
		auth.setStatus(Status.ACTIVE);
		auth.setWrongLoginAttempts(0);
		auth.setPasswordReset(false);
		
		user.setAuth(auth);
		
		Address address = new Address();
		address.setAddressLine1(registerForm.getAddress1());
		if (!StringUtils.isEmpty(registerForm.getAddress2())) {
			address.setAddressLine2(registerForm.getAddress2());
		}
		address.setCity(registerForm.getCity());
		address.setState(registerForm.getState());
		address.setZipcode(registerForm.getZip());
		address.setCountry(registerForm.getCountry());
		address.setAddressType(AddressType.OFFICE);
		
		user.setAddresses(new ArrayList<Address>());
		user.getAddresses().add(address);
		
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setPhoneNumber(registerForm.getPhone1());
		phoneNumber.setExten(registerForm.getPhone1Extn());
		phoneNumber.setPhoneType(PhoneType.OFFICE);
		
		user.setPhoneNumbers(new ArrayList<PhoneNumber>());
		user.getPhoneNumbers().add(phoneNumber);
		
		if (!StringUtils.isEmpty(registerForm.getPhone2())){
			phoneNumber = new PhoneNumber();
			phoneNumber.setPhoneNumber(registerForm.getPhone2());
			phoneNumber.setExten(registerForm.getPhone2Extn());
			phoneNumber.setPhoneType(PhoneType.HOME);
			
			user.getPhoneNumbers().add(phoneNumber);
		}
		try {
			userDao.addUser(user);
		} catch (Exception ex) {
			logger.error("", ex);
			return false;
		}
		return true;
	}

}
