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
package io.c12.bala.db.domain;

import java.util.List;

/**
 * @author b.palaniappan
 *
 */
public class Auth {

	private String userId;
	private String password;
	private Status status;
	private int wrongLoginAttempts;
	private boolean passwordReset;
	private List<String> accessList;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getWrongLoginAttempts() {
		return wrongLoginAttempts;
	}
	public void setWrongLoginAttempts(int wrongLoginAttempts) {
		this.wrongLoginAttempts = wrongLoginAttempts;
	}
	public boolean isPasswordReset() {
		return passwordReset;
	}
	public void setPasswordReset(boolean passwordReset) {
		this.passwordReset = passwordReset;
	}
	public List<String> getAccessList() {
		return accessList;
	}
	public void setAccessList(List<String> accessList) {
		this.accessList = accessList;
	}

}
