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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.c12.bala.service.UserService;
import io.c12.bala.view.form.RegistrationForm;

/**
 * @author b.palaniappan
 *
 */
@Controller
public class LoginController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	/**
	 * @return login string
	 * Login page redirect
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	/**
	 * @return welcome string
	 * Welcome page redirect
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	/**
	 * @return error String
	 * Error page Redirect
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}
	
	/**
	 * @param model
	 * @return register string
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		RegistrationForm registrationForm = new RegistrationForm();
		model.addAttribute("registrationForm", registrationForm);
		return "register";
	}
	
	/**
	 * @param registerForm
	 * @param model
	 * @return register string
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser( @Valid @ModelAttribute("formRegister") RegistrationForm registerForm, Model model) throws Exception {
		if (userService.addUser(registerForm)) {
			model.addAttribute("success", "User registered successfully");
		} else {
			model.addAttribute("Failed", "Error occured during registration, Try again later");
		}
		model.addAttribute("registrationForm", registerForm);
		return "register";
	}
	
	@RequestMapping(value = "/checkEmailExists", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> checkEmailExists(@RequestBody Map<String, String> dataMap) {
		Map<String, String> responseMap = new HashMap<String, String>();
		String userId = dataMap.get("email");
		responseMap.put("exists", userService.checkIfUserIdExists(userId) ? "Y" : "N");
		return responseMap;
	}

}
