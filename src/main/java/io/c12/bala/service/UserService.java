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

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.c12.bala.view.form.RegistrationForm;

/**
 * @author b.palaniappan
 *
 */
public interface UserService {
	
	/**
	 * @param userId
	 * @param password
	 * @return true if user id and password are authenticated
	 */
	public boolean authenticateUser(String userId, String password);
	
	/**
	 * @param registerForm
	 * @return
	 */
	public boolean addUser(RegistrationForm registerForm);
	
	/**
	 * @param userId
	 * @return List of Granted Authority for the user id
	 */
	public List<SimpleGrantedAuthority> getAuthorities(String userId);
	
	/**
	 * @param userId
	 * @return true if user id exists
	 */
	public boolean checkIfUserIdExists(String userId);
	
	/**
	 * @param userId
	 */
	public void generateAndSendForgotPasswordEmail(String userId);
	
}
