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
package io.c12.bala.view.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * @author b.palaniappan
 *
 */
@Getter
@Setter
public class RegistrationForm {

	@NotEmpty
	private String firstName;
	private String middleInitial;
	@NotEmpty
	private String lastName;
	private String suffix;
	@NotEmpty @Email
	private String email;
	@NotEmpty @Size(min=8, max=50)
	private String password;
	@NotEmpty @Size(min=8, max=50)
	private String confirmPassword;
	
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	private String phone1;
	private String phone1Extn;
	private String phone2;
	private String phone2Extn;

}
