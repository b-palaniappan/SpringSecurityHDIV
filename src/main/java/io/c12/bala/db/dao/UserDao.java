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
package io.c12.bala.db.dao;

import java.util.List;

import io.c12.bala.db.domain.User;

/**
 * @author b.palaniappan
 * 
 * DAO using arango DB.
 */
public interface UserDao {
	
	/**
	 * @param user
	 * @return saved user object
	 */
	public User addUser(User user);
	
	/**
	 * @param userId
	 * @return password has from DB
	 */
	public String getPasswordHashByUserId(String userId);
	
	/**
	 * @param paswordHash
	 * @param userKey
	 * @return Update the current password
	 * Used for Forgot password
	 */
	public boolean updatePassword(String paswordHash, String userKey);
	
	/**
	 * @param userId
	 * @return true if user id exists in DB
	 * Check if the user id exists
	 */
	public boolean checkUserIdExists(String userId);
	
	/**
	 * @param userId
	 * @return list of user roles
	 * get the user roels for the user id
	 */
	public List<String> getUserRole(String userId);

}
