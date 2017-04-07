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
package io.c12.bala.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author b.palaniappan
 *
 */
@Controller
public class LoginController {
	
	/**
	 * @return login string
	 * Login page redirect
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {
		return "login";
	}
	
	/**
	 * @return welcome string
	 * Welcome page redirect
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String Welcome() {
		return "welcome";
	}
	
	/**
	 * @return error String
	 * Error page Redirect
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String Error() {
		return "error";
	}
	
	@RequestMapping(value = "/register", method =  RequestMethod.GET)
	public String Register() {
		return "register";
	}

}
