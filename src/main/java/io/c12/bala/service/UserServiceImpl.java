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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lambdaworks.crypto.SCryptUtil;

import io.c12.bala.db.dao.UserDao;

/**
 * @author b.palaniappan
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name = "userDao")
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see io.c12.bala.service.UserService#authenticateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticateUser(String userId, String password) {
		String passwordHash = userDao.getPasswordHashByUserId(userId);
		return SCryptUtil.scrypt(password, 16,16,16).equals(passwordHash);
	}

}
